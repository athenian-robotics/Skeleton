package frc.team852.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.team852.Robot;
import frc.team852.RobotMap;
import frc.team852.commands.DriveWithSticksTank;


// control motor

public class DrivetrainTank extends Subsystem {

    private DifferentialDrive robotDrive = RobotMap.robotDrive;

    @Override
    protected void initDefaultCommand() {
        // init command initiates on call
        setDefaultCommand(new DriveWithSticksTank());
    }


    public void changeCommandMode() {
        // switch case driving method
        // TODO implement difference method of driving
        // implement changeCommandMode command
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

