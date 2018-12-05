package frc.team852.lib.utilities;

public class Translation2D implements ITranslation2D {


    protected final double x;
    protected final double y;

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

    @Override
    public Translation2D getTranslation() {
        return this;
    }

    @Override
    public String toJSON() {
        return String.format("{\"type\": \"Translation2D\", \"x\": %s, \"y\": %s}", x, y);
    }

}
