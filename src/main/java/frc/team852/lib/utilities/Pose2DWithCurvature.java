package frc.team852.lib.utilities;

public class Pose2DWithCurvature implements IPose2D, ICurvature {
    private final Pose2D pose;
    private final double curvature;
    private final double dcurvature_ds;

    public Pose2DWithCurvature(Pose2D pose, double curvature, double dcurvature_ds) {
        this.pose = pose;
        this.curvature = curvature;
        this.dcurvature_ds = dcurvature_ds;
    }

    public double distanceTo(ITranslation2D other) {
        return getTranslation().distanceTo(other);
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
    public String toCSV() {
        return String.format("%s,%.6f,%.6f", pose.toCSV(), curvature, dcurvature_ds);
    }
}