package frc.team852.lib.utilities;

public class Pose2DWithCurvature implements IPose2D, ICurvature {
    protected final Pose2D pose;
    protected final double curvature;
    protected final double dcurvature_ds;

    public Pose2DWithCurvature(Pose2D pose, double curvature, double dcurvature_ds) {
        this.pose = pose;
        this.curvature = curvature;
        this.dcurvature_ds = dcurvature_ds;
    }

    @Override
    public Pose2D getPose() {
        return pose;
    }

    @Override
    public Translation2D getTranslation() {
        return pose.getTranslation();
    }

    @Override
    public Rotation2D getRotation() {
        return pose.getRotation();
    }

    @Override
    public double getCurvature() {
        return curvature;
    }

    @Override
    public double getDCurvatureDs() {
        return dcurvature_ds;
    }

    @Override
    public String toJSON() {
        // TODO write JSON representation
        return "";
    }
}
