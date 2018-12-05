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

    public Translation2D inverse() {
        return new Translation2D(-x, -y);
    }

    public double norm() {
        return Math.hypot(x, y);
    }

    private Translation2D translateBy(Translation2D translation) {
        return new Translation2D(x + translation.x, y + translation.y);
    }

    public double distance(Translation2D translation) {
        return inverse().translateBy(translation).norm();
    }

    @Override
    public String toJSON() {
        // TODO write JSON representation
        return "";
    }

}
