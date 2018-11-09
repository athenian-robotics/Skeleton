package frc.team852.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team852.Robot;

/**
 * This entire command is specifically written for TANK DRIVE
 */
// TODO does print even work here??
// TODO print to driver station

public class TimedDrive extends Command {

    private double left;
    private double right;
    private double time;
    final private double power = 1;

    public TimedDrive(double left, double right, double time) {
        requires(Robot.drivetrain);
        this.left = left;
        this.right = right;
        this.time = time;
    }

    // turn left or right
    public TimedDrive(String position) {
        requires(Robot.drivetrain);
        this.time = 1; // TODO seconds not tuned

        switch (position) {
            case "left":
                this.left = -this.power;
                this.right = this.power;
                break;
            case "right":
                this.left = this.power;
                this.right = -this.power;
            case "turn":
                this.left = this.power;
                this.right = -this.power;
                this.time *= 2;
            default:
                System.out.println("Invalid turning position");
        }
    }

    // forward and backward
    public TimedDrive(String position, double time) {
        requires(Robot.drivetrain);
        this.time = time;

        switch (position) {
            case "forward":
                this.left = this.power;
                this.right = this.power;
                break;
            case "backward":
                this.left = -this.power;
                this.right = -this.power;
            default:
                System.out.println("Invalid driving parameter");
            }
    }

    @Override
    protected void execute() {
        Robot.drivetrain.drive(left, right);
        this.setTimeout(time);
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
