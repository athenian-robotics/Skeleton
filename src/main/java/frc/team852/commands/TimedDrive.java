package frc.team852.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team852.Robot;
import frc.team852.lib.utilities.PIDController;

/**
 * This entire command is specifically written for TANK DRIVE
 */

public class TimedDrive extends Command {

    private double left;
    private double right;
    //private double time;
    //final private double power = 1;
    private static int count = 0;
    PIDController pid = new PIDController(1,2,3);

    public TimedDrive(double left, double right, double time) {
        requires(Robot.drivetrain);
        this.left = left;
        this.right = right;
        setTimeout(time);
        count++;
        SmartDashboard.putNumber("NUMBER OF TIMEDDRIVES= ", count);
    }

    // turn left or right

    @Override
    protected void execute() {
        Robot.drivetrain.drive(left, right);
    }

    @Override
    protected boolean isFinished() {
        // Stop when execute completes
        return isTimedOut();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        // terminate if interrupted
        end();
    }
}
