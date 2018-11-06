package frc.team852.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.team852.Robot;
import frc.team852.RobotMap;
import frc.team852.commands.ChzDriveSticks;
import frc.team852.commands.DriveWithSticksTank;


// control motor

public class DrivetrainTank extends Subsystem {

    private DifferentialDrive robotDrive = RobotMap.robotDrive;

    private int activeDriveMode = 0;

    @Override
    protected void initDefaultCommand() {
        // init command initiates on call
        setDefaultCommand(new DriveWithSticksTank());
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
                this.setDefaultCommand(new DriveWithSticksTank());
                System.out.println("Tank drive");
                break;
            case 1:
                this.setDefaultCommand(new ChzDriveSticks());
                System.out.println("Chz");
                break;
        }
    }


    public void takeJoystickInputTank(Joystick left, Joystick right) {
        // controlled drive
        this.robotDrive.tankDrive(-left.getY(), -right.getY(), true);
    }

    public void drive(double left, double right) {
        // predetermined path
        this.robotDrive.tankDrive(-left, -right);
    }


    // stop
    public void stop() {
        this.robotDrive.stopMotor();  // something neat
    }



}

