package frc.team852.lib.geometry;

import frc.team852.lib.utilities.Pose2D;
import frc.team852.lib.utilities.Translation2D;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathGenerator {
    private final int numSampledPoints = 100;
    private Pose2D start;
    private List<Pose2D> waypoints = new ArrayList<>();
    private Pose2D end;
    private List<Spline> splines = new ArrayList<>();

    PathGenerator(Pose2D start, Pose2D end) {
        this.start = start;
        this.end = end;
    }

    PathGenerator(Pose2D start, List<Pose2D> waypoints, Pose2D end) {
        this(start, end);
        this.waypoints = waypoints;
    }


    List<Pose2D> generatePoints() {
        splines.add(new CubicSpline(start, end));
        for (int i = 0; i < waypoints.size() - 1; i++) {
            splines.add(new CubicSpline(waypoints.get(i), waypoints.get(i + 1)));
        }
        splines.add(new CubicSpline(waypoints.get(waypoints.size() - 1), end));
        for (Spline spline : splines) {
            List<Double> sampleValues = Stream
                    .iterate(0.0, n -> n + 1.0 / numSampledPoints)
                    .limit(1)
                    .collect(Collectors.toList());
            List<Translation2D> sampledPoses = new ArrayList<>();
            sampleValues.forEach((x) -> sampledPoses.add(spline.evaluateFunction(x)));

        }

        //TODO: Follow the Desmos demo and calculate list of poses

        return new ArrayList<>();
    }
}
