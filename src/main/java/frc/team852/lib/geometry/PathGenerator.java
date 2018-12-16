package frc.team852.lib.geometry;

import frc.team852.lib.utilities.Pose2D;
import frc.team852.lib.utilities.Translation2D;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PathGenerator {
    private final int maxSamples = 200;
    private final List<Pose2D> waypoints;
    private final List<Spline> splines = new ArrayList<>();

    PathGenerator(Pose2D start, Pose2D finish) {
        this.waypoints = new ArrayList<>(2);
        this.waypoints.add(start);
        this.waypoints.add(finish);
    }

    PathGenerator(List<Pose2D> waypoints) {
        assert(waypoints.size() >= 2);
        this.waypoints = waypoints;
    }

    PathGenerator(Pose2D first, Pose2D second, Pose2D ... rest) {
        waypoints = Arrays.asList(rest);
        waypoints.add(0, first);
        waypoints.add(1, second);
    }


    Pose2D getStart() {
        return waypoints.get(0);
    }

    Pose2D getEnd() {
        return waypoints.get(waypoints.size() - 1);
    }


    List<Pose2D> generatePoints(double distIncrement) {
        // Connect waypoints with splines
        for (int i = 0; i < waypoints.size() - 1; i++) {
            splines.add(new CubicSpline(waypoints.get(i), waypoints.get(i + 1)));
        }

        // Join the parametrized splines into a single list
        List<Pose2D> allIntervals = new ArrayList<>();

        // Parameterize splines
        for (Spline spline : splines) {
            // Twice as many samples as estimated by the upper bound should be plenty accurate
            int numSamples = 2 * (int) (spline.lengthUpperBound() / distIncrement);

            // It needs at least two samples, but anything over numSamples is excessive
            numSamples = Math.max(1, Math.min(maxSamples, numSamples));


            // Generate sample points
            Pose2D[] samples = new Pose2D[numSamples];
            double denom = numSamples - 1;

            for (int i = 0; i < numSamples; i++) {
                samples[i] = spline.samplePath(i / denom);
            }


            // Calculate distances for sample points
            double[] distances = new double[numSamples];
            distances[0] = 0;
            double maxStepDist = 0;

            for (int i = 1; i < numSamples; i++) {
                distances[i] = distances[i - 1] + samples[i - 1].distanceTo(samples[i]);
                maxStepDist = Math.max(maxStepDist, samples[i - 1].distanceTo(samples[i]));
            }

            // Find largest number of indices between two intervals
            int maxStep = (int) (maxStepDist / distIncrement) + 1;


            // Step along spline by distance intervals of distIncrement
            int numIntervals = (int) (distances[numSamples - 1] / distIncrement);
            Pose2D[] intervals = new Pose2D[numIntervals];
            intervals[0] = samples[0];

            int index = 0;
            for (int i = 1; i < numIntervals; i++) {
                // Find the bounding samples using a linear search
                while (distances[index + 1] < numIntervals * distIncrement) {
                    index++;
                }

                if (index >= numSamples)
                    index = numSamples - 1;

                // Interpolate based on distance
                double stepDist = distances[index + 1] - distances[index];
                intervals[i] = samples[index].interpolate(samples[index + 1],
                        i - distances[index] / distIncrement);
            }

            // Join intervals into a single list
            Collections.addAll(allIntervals, intervals);
        }

        return allIntervals;
    }
}
