package frc.team852.lib.geometry;

class CurvaturePose extends Pose {
    private double curvature;
    private double dcurvature_ds;

    CurvaturePose(Location l, Rotation r, double curvature, double dcurvature_ds){
        super(l,r);
        this.curvature = curvature;
        this.dcurvature_ds = dcurvature_ds;
    }


}
