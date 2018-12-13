package frc.team852.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import frc.team852.Robot;
import frc.team852.RobotMap;
import frc.team852.lib.utilities.PIDController;
import frc.team852.subsystems.DrivetrainSubsystem;

//TODO TEST THIS SHIT

public class DriveDistance extends Command {
    private DrivetrainSubsystem drivetrain = Robot.drivetrain;
    private PIDController leftPID, rightPID;
    private Encoder leftEncoder = RobotMap.leftDriveEncoder, rightEncoder = RobotMap.rightDriveEncoder;
    private double distance;
    private final double EPSILON;
    private boolean canCorrect;
    private final int dist_sign;

    /**
     * DriveDistance (You get whats on the box)
     *
     * @param cm How many centimeters to drive forward
     */
    public DriveDistance(double cm) {
        this(cm, 0.2, false);
    }

    public DriveDistance(double cm, double epsilon) {
        this(cm, epsilon, false);
    }

    public DriveDistance(double cm, boolean allowOvershoot) {
        this(cm, 0.2, allowOvershoot);
    }

    public DriveDistance(double cm, double epsilon, boolean allowOvershoot) {
        this.distance = cm;
        this.EPSILON = epsilon;
        this.canCorrect = allowOvershoot;
        this.dist_sign = sign(distance);
    }

    @Override
    protected void initialize() {
        // Assigning here should allow us to make changes without redeploying
        leftPID = RobotMap.leftDrivePID;
        rightPID = RobotMap.rightDrivePID;
        leftEncoder.setDistancePerPulse(RobotMap.DRIVE_DIST_PULSE);
        rightEncoder.setDistancePerPulse(RobotMap.DRIVE_DIST_PULSE);
        drivetrain.resetEncoders();
    }

    @Override
    protected void execute() {
        double leftOutput = leftPID.getPID(leftEncoder.getDistance(), this.distance);
        double rightOutput = rightPID.getPID(rightEncoder.getDistance(), this.distance);
        drivetrain.drive(leftOutput, rightOutput);
    }


    @Override
    protected boolean isFinished() {
        if (this.canCorrect)
            return (dist_sign * Math.abs(this.distance - leftEncoder.getDistance()) < EPSILON) && (dist_sign * Math.abs(this.distance - rightEncoder.getDistance()) < EPSILON);
        else
            return (dist_sign * (this.distance - leftEncoder.getDistance()) < EPSILON) && (dist_sign * (this.distance - rightEncoder.getDistance()) < EPSILON);

    }

    /**
     * @param num A number
     * @return The sign (+/-) of num
     */
    private int sign(double num) {
        return num < 0 ? -1 : 1;
    }

    @Override
    protected void end() {
        if (canCorrect)
            Robot.drivetrain.stop();
    }

    @Override
    protected void interrupted() {
        Robot.drivetrain.stop();
    }
}
