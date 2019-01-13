package frc.team852.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team852.Robot;
import frc.team852.RobotMap;

public class MoveArm extends Command {
    private double speed;

    public MoveArm(double speed) {
        this.speed = speed;
    }

    @Override
    public void execute() {
        if (RobotMap.lifterUpperLimit.get()) Robot.climber.setSpeed(-speed);
        else if (RobotMap.lifterLowerLimit.get()) Robot.climber.setSpeed(speed);
        else if (!RobotMap.lifterLowerLimit.get() && !RobotMap.lifterLowerLimit.get()) Robot.climber.setSpeed(speed);
    }

    @Override
    protected boolean isFinished() {
        return RobotMap.lifterLowerLimit.get() || RobotMap.lifterUpperLimit.get();
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {
        Robot.climber.setSpeed(0);
    }
}
