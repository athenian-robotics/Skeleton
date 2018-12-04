package frc.team852.lib.geometry;

import java.util.ArrayList;
import java.util.List;

public class PathGenerator {
    private CurvaturePose start;
    private List<CurvaturePose> waypoints = new ArrayList<>();
    private CurvaturePose end;

    PathGenerator(CurvaturePose start, CurvaturePose end){
        this.start = start;
        this.end = end;
    }

    PathGenerator(CurvaturePose start, List<CurvaturePose> waypoints, CurvaturePose end){
        this.start = start;
        this.end = end;
    }

    List<CurvaturePose> generateSpline(){
        return new ArrayList<>();
    }
}
