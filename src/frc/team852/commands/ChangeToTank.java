package frc.team852.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team852.Robot;

public class ChangeToTank extends Command {

    private boolean activated;

    public ChangeToTank() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        this.activated = false;
    }

    @Override
    protected void execute() {
        Robot.drivetrain.changeCommandMode(0);
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
