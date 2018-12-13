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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team852.subsystems.DrivetrainSubsystem;
import frc.team852.subsystems.SampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * top folder of the project.
 */

// TODO add smartdashboard PID tuning

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
    double[] leftGainz, rightGainz, oldLGainz, oldRGainz;

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
        leftGainz = new double[3];
        rightGainz = new double[3];
        oldLGainz = new double[3];
        oldRGainz = new double[3];
        for (String key : SmartDashboard.getKeys()) {
            SmartDashboard.delete(key);
        }
        SmartDashboard.putNumberArray("LEFT_PID", leftGainz);
        SmartDashboard.putNumberArray("RIGHT_PID", rightGainz);
        SmartDashboard.updateValues();
    }


    // called when disabled, clear systema
    @Override
    public void disabledInit() {
        drivetrain.resetEncoders();
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * <p>
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     * </p>
     * <p>
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     * </p>
     */

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();


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


    private void updatePIDGainz() {
        SmartDashboard.updateValues();
        leftGainz = SmartDashboard.getNumberArray("LEFT_PID", leftGainz);
        if (leftGainz != oldLGainz) {
            RobotMap.leftDrivePID.setGainz(leftGainz);
            oldLGainz = leftGainz;
            RobotMap.leftDrivePID.setGainz(leftGainz);
            RobotMap.leftDrivePID.reset();
        }
        rightGainz = SmartDashboard.getNumberArray("RIGHT_PID", rightGainz);
        if (rightGainz != oldRGainz) {
            RobotMap.rightDrivePID.setGainz(rightGainz);
            oldRGainz = rightGainz;
            RobotMap.rightDrivePID.setGainz(rightGainz);
            RobotMap.rightDrivePID.reset();
        }
    }

    // called periodically during operator control

    @Override
    public void teleopPeriodic() {
        updatePIDGainz();
        Scheduler.getInstance().run();
    }

    // called periodically during testing
    @Override
    public void testPeriodic() {
    }

    @Override
    public void robotPeriodic() {
        SmartDashboard.updateValues();
    }
}
