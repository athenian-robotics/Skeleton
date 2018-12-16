package frc.team852.lib.utilities;

public class Pose2D implements IPose2D {

    private final Translation2D translation;
    private final Rotation2D rotation;

    public Pose2D() {
        this.translation = new Translation2D();
        this.rotation = new Rotation2D();
    }

    public Pose2D(double x, double y, final Rotation2D rotation) {
        this.translation = new Translation2D(x, y);
        this.rotation = rotation;
    }


    public Pose2D(final Translation2D translation, final Rotation2D rotation) {
        this.translation = translation;
        this.rotation = rotation;
    }

    public Pose2D(final Pose2D other) {
        translation = new Translation2D(other.getTranslation());
        rotation = new Rotation2D(other.getRotation());
    }

    public double distanceTo(ITranslation2D other) {
        return getTranslation().distanceTo(other);
    }

    public Pose2D interpolate(IPose2D other, double t) {
        return new Pose2D(translation.interpolate(other.getTranslation(), t), rotation.interpolate(other.getRotation(), t));
    }

    @Override
    public Rotation2D getRotation() {
        return this.rotation;
    }

    @Override
    public Pose2D getPose() {
        return this;
    }

    @Override
    public Translation2D getTranslation() {
        return this.translation;
    }

    @Override
    public String toJSON() {
        return String.format("{\"type\": \"Pose2D\", \"translation\": %s, \"rotation\": %s}", translation.toJSON(), rotation.toJSON());
    }
}
