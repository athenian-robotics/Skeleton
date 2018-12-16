package frc.team852.lib.utilities;

public class Translation2D implements ITranslation2D {


    private final double x;
    private final double y;

    public Translation2D() {
        this.x = 0;
        this.y = 0;
    }

    public Translation2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Translation2D(Translation2D other) {
        this.x = other.x;
        this.y = other.y;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceTo(ITranslation2D other) {
        return Math.hypot(x - other.getTranslation().x, y - other.getTranslation().y);
    }

    public Translation2D interpolate(ITranslation2D other, double t) {
        return new Translation2D(x * (1 - t) + other.getTranslation().x * t, y * (1 - t) + other.getTranslation().y * t);
    }

    @Override
    public Translation2D getTranslation() {
        return this;
    }

    @Override
    public String toJSON() {
        return String.format("{\"type\": \"Translation2D\", \"x\": %s, \"y\": %s}", x, y);
    }

}
