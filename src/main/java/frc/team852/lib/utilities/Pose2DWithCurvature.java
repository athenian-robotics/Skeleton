package frc.team852.lib.utilities;

public class Pose2DWithCurvature implements IPose2D, ICurvature {
    @Override
    public IPose2D getPose() {
        return this;
    }

    @Override
    public Translation2D getTranslation() {
        return null;
    }

    @Override
    public Rotation2D getRotation() {
        return null;
    }
}
