package frc.team852.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import frc.team852.Robot;
import frc.team852.RobotMap;
import frc.team852.subsystems.DrivetrainSubsystem;

/**
 * Just a simple command to check how many tics/rev an encoder is using
 */

public class EncoderCalib extends Command {


    private final int numRot = 40;
    private DrivetrainSubsystem drivetrain;
    private Encoder leftEncoder, rightEncoder;
    private DigitalInput leftSwitch, rightSwitch;
    private double leftSpeed, rightSpeed;
    private int leftCount, rightCount;
    private boolean leftSwitchLast, rightSwitchLast, lFirstRot, rFirstRot;

    public EncoderCalib() {
        requires(Robot.drivetrain);
        drivetrain = Robot.drivetrain;
        leftEncoder = RobotMap.leftDriveEncoder;
        rightEncoder = RobotMap.rightDriveEncoder;
        leftSwitch = RobotMap.leftSwitch;
        rightSwitch = RobotMap.rightSwitch;
    }

    @Override
    protected void initialize() {
        Robot.drivetrain.stop();
        Robot.drivetrain.resetEncoders();
        System.out.println("[**] EncoderCalib initialized");
        leftCount = 0;
        rightCount = 0;
        leftSpeed = -0.8;
        rightSpeed = -0.8;
        lFirstRot = true;
        rFirstRot = true;
        leftSwitchLast = false;
        rightSwitchLast = false;
    }


    @Override
    protected void execute() {
        if (lFirstRot && leftSwitch.get()) {
            leftEncoder.reset();
            leftSwitchLast = true;
            lFirstRot = false;
        }
        if (rFirstRot && rightSwitch.get()) {
            leftEncoder.reset();
            rightSwitchLast = true;
            rFirstRot = false;
        }

        if (leftSwitch.get() && !leftSwitchLast) {
            leftCount++;
            System.out.printf("Left hit @ %d\n", leftEncoder.get());
        }

        if (rightSwitch.get() && !rightSwitchLast) {
            rightCount++;
            System.out.printf("Right hit @ %d\n", rightEncoder.get());
        }

        leftSwitchLast = leftSwitch.get();
        rightSwitchLast = rightSwitch.get();

        leftSpeed = (leftCount >= numRot) ? 0.0 : leftSpeed;
        rightSpeed = (rightCount >= numRot) ? 0.0 : rightSpeed;

        drivetrain.drive(leftSpeed, rightSpeed);
        //System.out.println("leftCount = " + leftCount);
        //System.out.println("rightCount = " + rightCount);
    }

    @Override
    protected boolean isFinished() {
        //System.out.println("(leftCount >= numRot && rightCount >= numRot) = " + (leftCount >= numRot && rightCount >= numRot));
        return leftCount >= numRot && rightCount >= numRot;
    }

    @Override
    protected void end() {
        // I forget if this halts the motors or just sets the drive val to 0
        Robot.drivetrain.stop();
        System.out.printf("[**] Left tics %d (AVG: %f):: Right tics %d (AVG: %f)\n", leftEncoder.get(), (double)leftEncoder.get()/numRot, rightEncoder.get(), (double)rightEncoder.get()/numRot);
    }

    protected void interrupted() {
        Robot.drivetrain.stop();
        System.out.println("[!!!!] Interupted");
    }
}
