package frc.team852.lib.geometry;

import java.util.ArrayList;
import java.util.List;

public class PathGenerator {
    private SpeedPose start;
    private List<SpeedPose> waypoints = new ArrayList<>();
    private SpeedPose end;

    PathGenerator(SpeedPose start, SpeedPose end){
        this.start = start;
        this.end = end;
    }

    PathGenerator(SpeedPose start, List<SpeedPose> waypoints, SpeedPose end){
        this.start = start;
        this.end = end;
    }

    List<SpeedPose> generateSpline(){
        return new ArrayList<>();
    }
}
