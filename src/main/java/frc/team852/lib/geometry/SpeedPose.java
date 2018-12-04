package frc.team852.lib.geometry;

class SpeedPose extends Pose {
    private double speed;

    SpeedPose(Location l, Rotation r, double speed){
        super(l,r);
        this.speed = speed;
    }

}
