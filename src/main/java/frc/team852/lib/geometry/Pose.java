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
}
