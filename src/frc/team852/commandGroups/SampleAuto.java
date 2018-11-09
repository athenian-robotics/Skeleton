package frc.team852.commandGroups;


import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team852.commands.TimedDrive;

public class SampleAuto extends CommandGroup {
    public SampleAuto() {
        this.addSequential(new TimedDrive(1,1,1)); // Move forward 4s
        this.addSequential(new TimedDrive(-1,1,1)); //turn left 3s
        this.addSequential(new TimedDrive(-1,-1,1)); //move backward 4s
    }
}
