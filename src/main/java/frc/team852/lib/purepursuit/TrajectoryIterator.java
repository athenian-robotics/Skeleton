package frc.team852.lib.purepursuit;

public class TrajectoryIterator {
    private final double x0, x1, y0, y1, curve0, curve1, orient0, orient1;

    TrajectoryIterator(TrajectoryPosition p0, TrajectoryPosition p1) {
        x0 = p0.getTranslation().getX();
        x1 = p1.getTranslation().getX();

        y0 = p0.getTranslation().getY();
        y1 = p1.getTranslation().getY();

        curve0 =



    }
}
