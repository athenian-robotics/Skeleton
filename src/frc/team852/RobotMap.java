/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team852;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * <p>
 * This is where mapping happens
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;

    public static SpeedController frontLeft = new PWMTalonSRX(0);
    public static SpeedController backLeft = new PWMTalonSRX(1);
    public static SpeedController frontRight = new PWMTalonSRX(2);
    public static SpeedController backRight = new PWMTalonSRX(3);

    public static SpeedControllerGroup leftDrive = new SpeedControllerGroup(frontLeft, backLeft);
    public static SpeedControllerGroup rightDrive = new SpeedControllerGroup(frontRight, backRight);

    public static DifferentialDrive robotDrive = new DifferentialDrive(leftDrive, rightDrive);

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
