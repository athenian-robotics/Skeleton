package frc.team852.lib.geometry;

public class Rotation {
    private double cos;
    private double sin;

    public Rotation(double x, double y){
        this.cos = x;
        this.sin = y;
    }
    public Rotation(double radians){
        this.cos = Math.cos(radians);
        this.sin = Math.sin(radians);
    }

    public double getCos() {
        return cos;
    }

    public double getSin() {
        return sin;
    }
}
