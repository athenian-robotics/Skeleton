package frc.team852.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.team852.RobotMap;
import frc.team852.commands.DriveChzStick;
import frc.team852.commands.DriveTankStick;


// control motor

public class DrivetrainSubsystem extends Subsystem {

    private DifferentialDrive robotDrive = RobotMap.robotDrive;

    private int activeDriveMode = 0;


    public DrivetrainSubsystem() {
        RobotMap.backLeft.setNeutralMode(NeutralMode.Brake);
        RobotMap.backRight.setNeutralMode(NeutralMode.Brake);
        RobotMap.frontLeft.setNeutralMode(NeutralMode.Brake);
        RobotMap.frontRight.setNeutralMode(NeutralMode.Brake);

    }

    @Override
    protected void initDefaultCommand() {
        // init command initiates on call
        setDefaultCommand(new DriveTankStick());
    }

    private void changeActiveDriveMode(int mode) {
        try {
            assert (mode == 1 || mode == 0);
            this.activeDriveMode = mode;
        } catch (AssertionError error) {
            System.out.println("Fail to change DriveMode, invalid Mode");
        }

    }

    public void changeCommandMode(int mode) {
        // switch case driving method
        this.changeActiveDriveMode(mode);
        switch (activeDriveMode) {
            case 0:
                this.setDefaultCommand(new DriveTankStick());
                System.out.println("Tank drive");
                break;
            case 1:
                this.setDefaultCommand(new DriveChzStick());
                System.out.println("Chz");
                break;
        }
    }

    public void drive(double left, double right) {
        // drive based on input
        this.robotDrive.tankDrive(left, right);
    }

    private double sketch_exp(double input, double pow){
        double sign = input < 0 ? -1 : 1;
        input = Math.abs(input);
        double output = input <.7906 ? (input/1.8)+.2 : Math.pow(input, pow);
        return output * sign;
    }
    // stop
    public void stop() {
        this.robotDrive.stopMotor();  // something neat
    }
}

