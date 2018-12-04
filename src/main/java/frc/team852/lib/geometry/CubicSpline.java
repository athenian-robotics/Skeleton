package frc.team852.lib.geometry;

import frc.team852.lib.utilities.Pose2D;

public class CubicSpline extends Spline {
    private double a;
    private double b;
    private double c;
    private double d;

    public CubicSpline(Pose2D start, Pose2D finish) {
        super(start, finish);
    }

    @Override
    void generatePath() {
        // TODO add coefficients
    }

    @Override
    Pose2D samplePath(float t) {
        return null;
    }
}
