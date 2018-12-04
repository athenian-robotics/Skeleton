package frc.team852.lib.geometry;

public class CubicSpline extends Spline {
    private double a;
    private double b;
    private double c;
    private double d;

    public CubicSpline(Pose start, Pose finish) {
        super(start, finish);
    }

    @Override
    void generatePath() {
        // TODO add coefficients
    }

    @Override
    Pose samplePath(float t) {
        return null;
    }
}
