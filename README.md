Go to **[MotionPlanning.md](https://github.com/athenian-robotics/Skeleton/blob/Trajectory-Planning/MotionPlanning.md)** for an explanation of the Motion Planning portion of this project.



This project is meant to serve as a starter code for FRC, for this robotics season and future years.
    
    
It has a tank drive and cheesy drive, PID controls, a [motion-planning](https://github.com/athenian-robotics/Skeleton/blob/Trajectory-Planning/MotionPlanning.md) module, and some other basic structures.

# Dependencies

> **[GradleRIO](https://github.com/wpilibsuite/GradleRIO)**
> * `chmod +x` and run `./dep_install.sh` to download and install and setup GradleRIO on Linux/MacOS
> * Run `dep_install`  (currently untested) to download and install and setup GradleRIO on Windows


# Hierarchy and Usage
> **RobotMap**: this is where you map your motors or anything else that connects to the roborio.

> **OI**: binds controller buttons and joysticks

> **Robot**: file that connects everything and runs them

> **Triggers**: declare button input

> **Subsystems**: declares **what to do**, make a system of commands and system, subsystem declares the methods while commands
declares the execution orders and function

> **Commands**: declares **how to do an action**, requires subsystem and execute a specific command

Subsystem class is declared and initialized in Robot <p>
The subsystem object is passed into a command


# TODO

> Implement Feed Forward Augment Control PID

> Add Encoder Skeleton

> Create Drive Mode Trigger, probably will be one of the button on the joystick

> Pack CTRE Motor Library into Dependency
