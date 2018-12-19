# Welcome
This is a brief guide to our project. This GitHub repository has all of the code necessary to run the robot manually, run it autonomously either based on time or distance, and generate a spline and display it with Python's Turtle module.

# Dependencies
We are managing our dependencies with [GradleRIO](https://github.com/wpilibsuite/GradleRIO). You can check out the build.gradle for more info. 

# Robot
If you're interested in what the actual robot code looks like, check out this section. We included it mainly because the code doesn't make sense without this.
If not, move to the Path Finding section.

## Configuration
> **RobotMap**: declares motors, encoders, and other I/O devices connected to the RoboRIO
>
> **OI**: binds controller buttons and joysticks to commands
>
> **Robot**: connects everything and runs it all
>
> **Subsystems**: describe parts of the robot (groups of motors and sensors) that are controlled independently

## Moving the Robot
> **Commands**: define actions that act on a specific subsystem (for instance, _DriveDistance_ acts on the Drivetrain subsystem)
>
> **CommandGroups**: allow chaining groups of subsystems together, either sequentially or in parallel


# Path Finding
This is mainly what we worked on for the AP Computer Science Project. All files referenced are [here](https://github.com/athenian-robotics/Skeleton/tree/Trajectory-Planning/src/main/java/frc/team852/lib).
If you're confused on how the spline path is generated, see [here](https://www.desmos.com/calculator/9msyr0xwnp). If you want to visualize how the discrete points are generated from the path, see [here](https://www.desmos.com/calculator/t7kzds8hvg).
##Utilities
## Utilities
> **Geometric Objects**

> Note: the interfaces are not included for brevity, but every geometric object has an interface 
* Rotation2D: Data type for rotation/heading of robot
* Translation2D: Data type for location of robot
* Pose2D: Combines Rotation2D and Translation2D for a position object
* Pose2DWithCurvature: Adds curvature to Pose2D; makes it easier to follow the path
* Trajectory: A list of Pose2D
* CSVEditor: A class for creating, saving CSV files; **calling this main method will run the code**
## Geometry
* CubicSpline: Draws a spline between two poses; has utility functions for splines
* PathGenerator
    > * Draw a spline between each waypoint
    > * Sample the spline and connect each sampled points with linear segments
    > * Use the linear segments as an approximation for finding equidistant points on the spline
## Generated_Path
* path_draw.py: reads the csv file (command-line argument) and draws the path using Python Turtle

##Running the Path Finder
* Run [CSVEditor.java](https://github.com/athenian-robotics/Skeleton/tree/Trajectory-Planning/src/main/java/frc/team852/lib/utilities/CSVEditor.java) to generate the path
* Run [path_draw.py](https://github.com/athenian-robotics/Skeleton/tree/Trajectory-Planning/src/main/java/frc/team852/lib/utilities/generated_path/path_draw.py) to visualize the path



