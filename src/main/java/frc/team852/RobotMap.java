package frc.team852;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;

import frc.team852.lib.utilities.InvertedDigitalInput;
import frc.team852.lib.utilities.PIDController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring.
 */

public class RobotMap {

    // Hardware
    // Motor controllers
    public static WPI_VictorSPX frontRight = new WPI_VictorSPX(0);
    public static WPI_VictorSPX backRight = new WPI_VictorSPX(1);
    public static WPI_VictorSPX frontLeft = new WPI_VictorSPX(3);
    public static WPI_VictorSPX backLeft = new WPI_VictorSPX(2);

    // Groupings of motor controllers
    public static SpeedControllerGroup rightDrive = new SpeedControllerGroup(frontLeft, backLeft);
    public static SpeedControllerGroup leftDrive = new SpeedControllerGroup(frontRight, backRight);

    public static DifferentialDrive robotDrive = new DifferentialDrive(leftDrive, rightDrive);

    // Sensors on the Rio (if the DS reads no code and your build was successful check here first for dupe channels)
    public static Encoder rightDriveEncoder = new Encoder(0, 1);
    public static Encoder leftDriveEncoder = new Encoder(2, 3);

    // dummy limit switches for encoder calib, not needed
    public static DigitalInput leftSwitch = new DigitalInput(6);
    public static DigitalInput rightSwitch = new DigitalInput(7);

    // Software
    public static PIDController leftDrivePID = new PIDController(1, 0.0, 0.0);
    public static PIDController rightDrivePID = new PIDController(1, 0.0, 0.0);
    public static final double DRIVE_WHEEL_DIAMETER = 15.24; // cm
    public static final double DRIVE_DIST_PULSE = 0.2037356257; // cm = 1 pulseAssuming 235 pulses/rotation is correct TODO verify encoder pulses/revolution

    // climber
    public static Spark climberMotor = new Spark(4);

    // limit switches
    public static DigitalInput lifterUpperLimit = new InvertedDigitalInput(4);
    public static DigitalInput lifterLowerLimit = new InvertedDigitalInput(5);


}
