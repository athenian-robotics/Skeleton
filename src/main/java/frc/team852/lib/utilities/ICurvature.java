/**
 * Interface implemented by any objects that contain curvature (such as Pose2DWithCurvature)
 */
package frc.team852.lib.utilities;

public interface ICurvature extends CSVWritable {
    double getCurvature();

    double getDCurvatureDs();
}
