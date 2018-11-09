This should be a good starter code for this year and hopefully the year to come, it's not too broad, and it's specific enough to basically serve
as a starter code for the actual robot.

It has a ~~hopefully~~ working tank drive and cheesy drive, PID controls, and some other basic structures.

# Dependencies

> FRC Plugin
> * Make sure you have the LATEST version of IntelliJ and WpiLib! Or else it WILL NOT work!
> * To update WpiLib to the latest version ``tool -> FRC -> Download Latest WpiLib``
> * To update IntelliJ ``Help -> Check for Update``

> TalonSRX Motor Controller Library: https://github.com/CrossTheRoadElec/Phoenix-Documentation


# Set Up

Follow https://20dzhong.github.io/gradleSetup/ for setup instructions, or just ask a Programming Lead.


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