package frc.team852.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.team852.Robot;
import frc.team852.RobotMap;
import frc.team852.commands.DriveWithSticksTank;


// controlls motor

public class DrivetrainTank extends Subsystem {

    private DifferentialDrive robotDrive = RobotMap.robotDrive;

    @Override
    protected void initDefaultCommand() {
        // init command initiates on call

    }
}
