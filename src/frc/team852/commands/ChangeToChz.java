package frc.team852.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team852.Robot;

public class ChangeToChz extends Command {

    private boolean activated;

    public ChangeToChz() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        this.activated = false;
    }

    @Override
    protected void execute() {
        Robot.drivetrain.changeCommandMode(1);
        this.activated = true;
    }

    @Override
    protected boolean isFinished() {
        return this.activated;
    }

    @Override
    protected void interrupted() {
        end();
    }
}
