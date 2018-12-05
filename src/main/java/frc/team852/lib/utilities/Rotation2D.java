package frc.team852.lib.utilities;

public class Rotation2D implements IRotation2D {
    protected final double cos;
    protected final double sin;

    public Rotation2D() {
        this.cos = 1;
        this.sin = 0;
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

    @Override
    public Rotation2D getRotation() {
        return this;
    }

    @Override
    public String toJSON() {
        // TODO write JSON representation
        return "";
    }
}
