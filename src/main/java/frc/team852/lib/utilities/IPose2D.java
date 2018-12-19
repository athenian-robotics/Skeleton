/**
 * Interface that extends ITranslation2D and IRotation2D
 * Is implemented by any pose object (such as Pose2D and Pose2DWithCurvature)
 */
package frc.team852.lib.utilities;

public interface IPose2D extends ITranslation2D, IRotation2D, CSVWritable {
    IPose2D getPose();
}
