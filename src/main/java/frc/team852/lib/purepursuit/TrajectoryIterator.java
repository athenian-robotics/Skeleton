package frc.team852.lib.purepursuit;

import frc.team852.lib.utilities.Rotation2D;

public class TrajectoryIterator {
    private final double x0, x1, y0, y1, curve0, curve1, rot0, rot1;
    private final Rotation2D rot0, rot1;

    TrajectoryIterator(TrajectoryPosition p0, TrajectoryPosition p1) {
        x0 = p0.getTranslation().getX();
        x1 = p1.getTranslation().getX();

        y0 = p0.getTranslation().getY();
        y1 = p1.getTranslation().getY();

        curve0 = p0.getCurvature();
        curve1 = p1.getCurvature();

        rot0 = p0.getRotation();
        rot1 = p1.getRotation();





    }
}
