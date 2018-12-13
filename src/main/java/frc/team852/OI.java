package frc.team852;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team852.commandGroups.SampleAuto;
import frc.team852.commands.ChangeToChz;
import frc.team852.commands.ChangeToTank;
import frc.team852.commands.DriveDistance;
import frc.team852.commands.EncoderCalib;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    // CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    // joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new SampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new SampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new SampleCommand());

    //public static Joystick leftStick = new Joystick(0);
    //public static Joystick rightStick = new Joystick(1);

    //public static Joystick xbox = new Joystick(2);

    //public static Button xboxA = new JoystickButton(xbox, 1);

    public static Joystick stick1 = new Joystick(0);
    public static Joystick stick2 = new Joystick(1);

    public OI() {
        new JoystickButton(stick1, 1).whenReleased(new DriveDistance(200));
    }
}
