package frc.team852.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.team852.OI;
import frc.team852.Robot;

public class ChzStickDrive extends Command {


    public ChzStickDrive() {
        // why always call on the superclass structure?
        super();
        requires(Robot.drivetrain);
    }

    @Override
    protected void initialize() {
    }

    private double boundThrottle(double throttle) {
        return throttle < 0 ? Math.max(throttle, -1) : Math.min(throttle, 1);
    }

    @Override
    protected void execute() {
        // TODO what trigger
        boolean quickTurn = OI.stick2.getTrigger();
		double forward = OI.stick1.getY();
		double turn = OI.stick2.getX();

		// Might need to flip signs
		if (!quickTurn) {
			Robot.drivetrain.drive(boundThrottle(forward + turn * forward), boundThrottle(forward - turn * forward));
		} else {
			Robot.drivetrain.drive(boundThrottle(forward + turn), boundThrottle(forward - turn));
		}
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