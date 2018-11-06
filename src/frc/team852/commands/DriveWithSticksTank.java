package frc.team852.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.team852.OI;
import frc.team852.Robot;

public class DriveWithSticksTank extends Command {


    public DriveWithSticksTank() {
        super();
        requires(Robot.drivetrain);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.drivetrain.takeJoystickInputTank(OI.stick1, OI.stick2);

    }

    @Override
    protected boolean isFinished() {
        // Never stop the drivetrain
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        // terminate if interrupted
        end();
    }
}