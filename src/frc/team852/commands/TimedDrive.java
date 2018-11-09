package frc.team852.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team852.OI;
import frc.team852.Robot;

public class TimedDrive extends Command {

    private double left;
    private double right;
    private double seconds;
    private long time;
    public TimedDrive(double left, double right, double seconds) {
        // TODO why super(); ?
        super();
        requires(Robot.drivetrain);
        this.left = left;
        this.right = right;
        this.seconds = seconds;
        this.time = System.currentTimeMillis();
    }

    @Override
    protected void initialize() {


    }

    @Override
    protected void execute() {
        Robot.drivetrain.drive(left, right);
        this.setTimeout(seconds);
        Robot.drivetrain.stop();
        end();
    }

    @Override
    protected boolean isFinished() {
        // Stop when execute completes
        return false;
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
