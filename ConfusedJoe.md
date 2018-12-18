#Skeleton
This is a brief guide to our project. This GitHub repo has all of the code necessary to run the robot manually, run it autonomously either based on time or distance, and generate a spline and display it with Python.

#Dependencies
We are managing our dependencies with [GradleRIO](https://github.com/wpilibsuite/GradleRIO). You can check out the build.gradle for more info. 
#Robot
##Configuration
> **RobotMap**: this is where you map your motors or anything else that connects to the roborio.

> **OI**: binds controller buttons and joysticks

> **Robot**: file that connects everything and runs them

> **Triggers**: declare button input

> **Subsystems**: independent parts of the robot that are controlled separately
##Moving the Robot

> **Commands**: actions that act on a specific subsystem (for instance [DriveDistance](https://github.com/athenian-robotics/Skeleton/blob/Trajectory-Planning/src/main/java/frc/team852/commands/DriveDistance.java)  act on the Drivetrain)

> **CommandGroups**: chaining groups of subsystems together, either _sequentially_ or _parallelly_

#Path Finding
##Utilities
> **Geometric Objects**
> * Rotation2D:
> * Translation2D
> * Pose2D: 
> * Pose2DWithCurvature
> * Trajectory
> * CSVEditor
##Geometry
> * CubicSpline
> * PathGenerator
> * Spline
##Generated_Path
> * path_draw.py






