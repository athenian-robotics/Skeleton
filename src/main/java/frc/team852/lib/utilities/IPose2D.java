package frc.team852.lib.utilities;

public interface IPose2D extends ITranslation2D, IRotation2D, JSONWritable {
    IPose2D getPose();
}
