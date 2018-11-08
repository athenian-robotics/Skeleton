package frc.team852.commandGroups;


import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team852.commands.TimedDrive;

public class SampleAuto extends CommandGroup {
    public SampleAuto() {
        this.addSequential(new TimedDrive(1,1,4)); // Move forward 4s
        this.addSequential(new TimedDrive(-1,1,3)); //turn left 3s
        this.addSequential(new TimedDrive(-1,-1,4)); //move backward 4s
    }
}
