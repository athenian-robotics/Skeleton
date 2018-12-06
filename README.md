This should be a good starter code for this year and hopefully the year to come, it's not too broad, and it's specific enough to basically serve
as a starter code for the actual robot.

It has a ~~hopefully~~ working tank drive and cheesy drive, PID controls, and some other basic structures.

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

> **Comamnds**: decalres **how to do an action**, requires subsystem and execute a specific command

Subsystem class is declared and initialized in Robot <p>
The subsystem object is passed into a command


# TODO

> Implement Feed Forward Augment Control PID

> Add Encoder Skeleton

> Create Drive Mode Trigger, probably will be one of the button on the joystick

> Pack CTRE Motor Library into Dependency
