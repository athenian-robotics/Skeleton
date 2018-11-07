/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team852;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.team852.subsystems.*;

// TODO add PID Control
// TODO add Triggers for Drivetrain?
// TODO add xBOX Buttons

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */

// If you rename or move this class, update the build.properties file in the project root

public class Robot extends TimedRobot {

    // operator interface for systems
    public static OI oi;

    // subsystems
    public static SampleSubsystem example;
    public static DrivetrainSubsystem drivetrain;

    // commands
    private Command autonomousCommand;
    private SendableChooser<Command> chooser = new SendableChooser<>();

    // var
    public String gameMsg;
    public static DriverStation driverStation = DriverStation.getInstance();

    // initialization
    @Override
    public void robotInit() {

        // initialization, this is how you initialize a subsystem
        drivetrain = new DrivetrainSubsystem();
        example = new SampleSubsystem();

        oi = new OI(); // must be defined last
        new RobotMap(); // empty declaration to create it


        // chooser.addDefault("Default Auto", new SampleCommand());
        // chooser.addObject("My Auto", new MyAutoCommand());
        // SmartDashboard.putData("Auto mode", chooser);
    }


    // called when disabled, clear system
    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * <p>You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();

        // gaming messages during auto:
        // this.gameMsg = Robot.driverStation.getGameSpecificMessage();

        /*
         * String autoSelected = SmartDashboard.getString("Auto Selector",
         * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
         * = new MyAutoCommand(); break; case "Default Auto": default:
         * autonomousCommand = new SampleCommand(); break; }
         */

        // schedule the autonomous command (example)
        if (autonomousCommand != null) {
            autonomousCommand.start();
        }
    }

    // called during auto
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }


    @Override
    public void teleopInit() {
        // Stop autonomous when teleop start
        // remove if you want auto to continue till stopped by a command
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
    }


    // called periodically during operator control
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    // called periodically during testing
    @Override
    public void testPeriodic() {
    }
}
