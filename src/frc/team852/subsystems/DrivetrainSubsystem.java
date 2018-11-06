package frc.team852.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.team852.RobotMap;
import frc.team852.commands.ChzStickDrive;
import frc.team852.commands.TankStickDrive;


// control motor

public class DrivetrainSubsystem extends Subsystem {

    private DifferentialDrive robotDrive = RobotMap.robotDrive;

    private int activeDriveMode = 0;

    @Override
    protected void initDefaultCommand() {
        // init command initiates on call
        setDefaultCommand(new TankStickDrive());
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
                this.setDefaultCommand(new TankStickDrive());
                System.out.println("Tank drive");
                break;
            case 1:
                this.setDefaultCommand(new ChzStickDrive());
                System.out.println("Chz");
                break;
        }
    }

    public void drive(double left, double right) {
        // drive based on input
        this.robotDrive.tankDrive(-left, -right);
    }


    // stop
    public void stop() {
        this.robotDrive.stopMotor();  // something neat
    }



}

