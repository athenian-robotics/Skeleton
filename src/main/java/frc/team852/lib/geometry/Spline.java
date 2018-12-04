package frc.team852.lib.geometry;

import frc.team852.lib.utilities.Pose2D;

public abstract class Spline {
    private Pose2D start;
    private Pose2D finish;

    public Spline(Pose2D start, Pose2D finish) {
        this.start = start;
        this.finish = finish;
    }

    public Pose2D getStart() {
        return start;
    }

    public Pose2D getFinish() {
        return finish;
    }

    abstract void generatePath();

    abstract Pose2D samplePath(float t);
}
