#Welcome
This is a brief guide to our project. This GitHub repository has all of the code necessary to run the robot manually, run it autonomously either based on time or distance, and generate a spline and display it with Python's Turtle module.

#Dependencies
We are managing our dependencies with [GradleRIO](https://github.com/wpilibsuite/GradleRIO). You can check out the build.gradle for more info. 

#Robot
##Configuration
> **RobotMap**: declares motors, encoders, and other I/O devices connected to the RoboRIO
>
> **OI**: binds controller buttons and joysticks to commands
>
> **Robot**: connects everything and runs it all
>
> **Subsystems**: describe parts of the robot (groups of motors and sensors) that are controlled independently

##Moving the Robot
> **Commands**: define actions that act on a specific subsystem (for instance, _DriveDistance_ acts on the Drivetrain subsystem)
>
> **CommandGroups**: allow chaining groups of subsystems together, either sequentially or in parallel

#Path Finding
##Utilities
**Geometric Objects**
* Rotation2D
* Translation2D
* Pose2D
* Pose2DWithCurvature
* Trajectory
* CSVEditor
##Geometry
* CubicSpline
* PathGenerator
* Spline
##Generated_Path
* path_draw.py






