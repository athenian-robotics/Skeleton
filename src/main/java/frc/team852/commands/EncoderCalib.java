package frc.team852.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import frc.team852.Robot;
import frc.team852.RobotMap;

public class EncoderCalib extends Command {
    private int numEpoch;
    private int rotCount;
    private boolean leftSide;
    private double runSpeed;
    private DigitalInput testSwitch = RobotMap.testSwtich;
    private Encoder testEncoder;
    private boolean lastSwitchVal;
    public EncoderCalib() {
        requires(Robot.drivetrain);
        this.numEpoch = 3;
        this.leftSide = false;
        this.runSpeed = 0.5;
        this.rotCount = 0;
        this.testEncoder = leftSide ? RobotMap.leftDriveEncoder : RobotMap.rightDriveEncoder;
        this.lastSwitchVal = false;
    }

    public EncoderCalib s_runSpeed(double speed) {
        this.runSpeed = speed;
        return this;
    }

    public EncoderCalib s_leftSide(boolean leftSide) {
        this.leftSide = leftSide;
        return this;
    }

    public EncoderCalib s_numEpoch(int numEpoch) {
        this.numEpoch = numEpoch;
        return this;
    }

    protected void initialize() {
        testEncoder.reset();
    }

    @Override
    protected void execute() {
        if (!leftSide) {
            Robot.drivetrain.drive(runSpeed, 0);
        } else {
            Robot.drivetrain.drive(0, runSpeed);
        }
        System.out.println("testEncoder = " + testEncoder.get());
        if (testSwitch.get() && testSwitch.get() != lastSwitchVal) {
            System.out.println("SWITCH HIT");
            rotCount++;
            lastSwitchVal = true;
        }
        lastSwitchVal = false;
    }

    @Override
    protected boolean isFinished() {
        return numEpoch == rotCount;
    }

    @Override
    protected void end() {
        System.out.println("DONE");
        int ticks = testEncoder.get();
        System.out.printf("NUM ROTATIONS: %d\n\t\tTICKS COUNTED: %d\n\t\tAVG TICKS/ROT: %f\n\n",
                numEpoch, ticks, (double) ticks / numEpoch);
        Robot.drivetrain.stop();
    }
    @Override
    protected void interrupted(){
        end();
    }
}