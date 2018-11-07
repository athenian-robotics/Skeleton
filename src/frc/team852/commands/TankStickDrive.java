package frc.team852.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.team852.OI;
import frc.team852.Robot;

public class TankStickDrive extends Command {


    public TankStickDrive() {
        // TODO why super(); ?
        super();
        requires(Robot.drivetrain);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.drivetrain.drive(OI.stick1.getY(), OI.stick2.getY());

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