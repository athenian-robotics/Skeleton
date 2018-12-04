package frc.team852.lib.utilities;

public class Translation2D implements ITranslation2D {


    protected double x;
    protected double y;

    public Translation2D() {
        this.x = 0;
        this.y = 0;
    }

    public Translation2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Translation2D(Translation2D other) {
        this.x = other.getX();
        this.y = other.getY();
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
}
