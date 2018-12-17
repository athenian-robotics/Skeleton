package frc.team852.lib.utilities;

public class Rotation2D implements IRotation2D {
    private final double cos;
    private final double sin;

    public Rotation2D() {
        this.cos = 1;
        this.sin = 0;
    }

    public Rotation2D(double angle) {
        this.cos = Math.cos(angle);
        this.sin = Math.sin(angle);
    }

    public Rotation2D(double cos, double sin) {
        this.cos = cos;
        this.sin = sin;
    }

    public Rotation2D(Rotation2D other) {
        this.cos = other.cos;
        this.sin = other.sin;
    }

    public double getCos() {
        return cos;
    }

    public double getSin() {
        return sin;
    }

    public double getAngle() {
        return Math.atan2(sin, cos);
    }

    public double angleTo(IRotation2D other) {
        Rotation2D o = other.getRotation().inverse();
        return inverse().rotate(o).getAngle();
    }

    public Rotation2D inverse() {
        return new Rotation2D(cos, -sin);
    }

    public Rotation2D rotate(IRotation2D other) {
        Rotation2D o = other.getRotation().inverse();
        return new Rotation2D(cos * o.cos - sin * o.sin, cos * o.sin + sin * o.cos);
    }

    public Rotation2D rotate(double a) {
        return rotate(new Rotation2D(a));
    }

    public Rotation2D scale(double s) {
        return new Rotation2D(s * getAngle());
    }

    public Rotation2D interpolate(IRotation2D other, double t) {
        Rotation2D o = other.getRotation().inverse();
        return rotate(t * angleTo(o));
    }

    @Override
    public Rotation2D getRotation() {
        return this;
    }

    @Override
    public String toCSV() {
        return String.format("%.6f,%.6f,", cos, sin);
    }
}
