package frc.team852.lib.utilities;

public class Rotation2D implements IRotation2D {
    protected double cos;
    protected double sin;

    public Rotation2D() {

    }

    public Rotation2D(Rotation2D rotation) {

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
