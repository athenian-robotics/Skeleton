package frc.team852.lib.geometry;

import frc.team852.lib.utilities.Pose2DWithCurvature;

import java.util.ArrayList;
import java.util.List;

public class PathGenerator {
    private Pose2DWithCurvature start;
    private List<Pose2DWithCurvature> waypoints = new ArrayList<>();
    private Pose2DWithCurvature end;

    PathGenerator(Pose2DWithCurvature start, Pose2DWithCurvature end){
        this.start = start;
        this.end = end;
    }

    PathGenerator(Pose2DWithCurvature start, List<Pose2DWithCurvature> waypoints, Pose2DWithCurvature end){
        this.start = start;
        this.end = end;
    }

    List<Pose2DWithCurvature> generateSpline(){
        return new ArrayList<>();
    }
}
