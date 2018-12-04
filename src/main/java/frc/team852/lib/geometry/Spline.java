package frc.team852.lib.geometry;

public abstract class Spline {
    private Pose start;
    private Pose finish;

    public Spline(Pose start, Pose finish) {
        this.start = start;
        this.finish = finish;
    }

    public Pose getStart() {
        return start;
    }

    public Pose getFinish() {
        return finish;
    }

    abstract void generatePath();

    abstract Pose samplePath(float t);
}
