package frc.team852.commandGroups;


import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team852.commands.TimedDrive;

public class SampleAuto extends CommandGroup {
    public SampleAuto(double power) {

        // this.addSequential(new TimedDrive(power,power,0.3)); // Move forward 4s
        // this.setTimeout(0.5);
        // this.addSequential(new TimedDrive(power,power,0.3)); //turn left 3s
        //this.setTimeout(0.5);
        // this.addSequential(new TimedDrive(-power,-power,0.3)); //move backward 4s
        // this.addSequential(new TimedDrive("left", 1));

        // turn and go forward for 1.5 seconds
    }

    public SampleAuto() {
        // this.addSequential(new TimedDrive("left"));
        //this.addSequential(new TimedDrive("forward", 1.5));

        // turn backward and go forward
        // this.addSequential(new TimedDrive("backward"));
        // this.addSequential(new TimedDrive("forward", 1.5));

    }
}
