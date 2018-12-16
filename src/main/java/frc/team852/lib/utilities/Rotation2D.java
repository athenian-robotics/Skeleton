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

    public Rotation2D inverse() {
        return new Rotation2D(cos, -sin);
    }

    public Rotation2D interpolate(IRotation2D other, double t) {
        // TODO please finish
        Rotation2D o = other.getRotation().inverse();
        return new Rotation2D(
//                cos * o.cos - sin * o.sin,
//                blah blah blah
        );
    }

    @Override
    public Rotation2D getRotation() {
        return this;
    }

    @Override
    public String toJSON() {
        return String.format("{\"type\": \"Rotation2D\", \"cos\": %s, \"sin\": %s}", cos, sin);
    }
}
