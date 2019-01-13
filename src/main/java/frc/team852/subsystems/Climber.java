package frc.team852.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team852.RobotMap;

public class Climber extends Subsystem {

    @Override
    protected void initDefaultCommand() {
        // nothing
    }

    SpeedController climberRotator = RobotMap.climberMotor;

    // TODO find limit switch :(
    public DigitalInput upperClimbLimit = RobotMap.lifterUpperLimit;
    public DigitalInput lowerClimbLimit = RobotMap.lifterLowerLimit;

    public void setSpeed(double speed) {
        System.out.println("Lower Climb Limit: " + lowerClimbLimit.get());
        System.out.println("Upper Climb Limit: " + upperClimbLimit.get());

        climberRotator.set(speed);
    }
}
