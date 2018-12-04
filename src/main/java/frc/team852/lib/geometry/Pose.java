package frc.team852.lib.geometry;

public class Pose {
    private Rotation rotation;
    private Location location;

    Pose(Location l, Rotation r){
        this.location = l;
        this.rotation = r;
    }

    public Location getLocation() {
        return location;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public double getX() { return location.getX(); }

    public double getY() { return location.getY(); }

    public double getCos() {
        return rotation.getCos();
    }

    public double getSin() {
        return rotation.getSin();
    }
}
