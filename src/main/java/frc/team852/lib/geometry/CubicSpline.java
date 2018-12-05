package frc.team852.lib.geometry;

import frc.team852.lib.utilities.Pose2D;

public class CubicSpline extends Spline {
    private double ax, bx, cx, dx, ay, by, cy, dy, x0, x1, dx0, dx1, y0, y1, dy0, dy1;

    public CubicSpline(Pose2D start, Pose2D finish) {
        super(start, finish);
        x0 = start.getTranslation().getX();
        x1 = finish.getTranslation().getX();
        y0 = start.getTranslation().getY();
        y1 = finish.getTranslation().getY();
        double scale = 2 * Math.hypot(x1-x0, y1-y0);
        dx0 = start.getRotation().getCos() * scale;
        dx1 = finish.getRotation().getCos() * scale;
        dy0 = start.getRotation().getSin() * scale;
        dy1 = finish.getRotation().getSin() * scale;
        generatePath();
    }

    @Override
    void generatePath() {
        ax = dx0 + dx1 + 2 * x0 - 2 * x1;
        bx = -2 * dx0 - dx1 - 3 * x0 + 3 * x1;
        cx = dx0;
        dx = x0;
        ay = dy0 + dy1 + 2 * y0 - 2 * y1;
        by = -2 * dy0 - dy1 - 3 * y0 + 3 * y1;
        cy = dy0;
        dy = y0;
    }

    @Override
    Pose2D samplePath(float t) {
        return null;
    }
}
