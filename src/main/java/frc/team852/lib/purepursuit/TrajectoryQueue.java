package frc.team852.lib.purepursuit;

import frc.team852.lib.utilities.IPose2D;
import frc.team852.lib.utilities.Trajectory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;


// parse json file
public class TrajectoryQueue<P> implements Iterable<P> {
    private static final String workingPath = "/src/main/java/frc/team852/lib/utilities/generated_path/";
    private String systemPath = (new File("./")).getAbsoluteFile() + workingPath;
    private String absPath;

    protected LinkedList<P> trajectoryQueue;


    TrajectoryQueue(String name) {

        absPath = systemPath + name;

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(absPath));
            JSONObject jsonContent = (JSONObject) obj;

            String type = (String) jsonContent.get("type");
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

    }

    public boolean add(P p) {
        return trajectoryQueue.add(p);
    }

    public Iterator<P> iterator() {
        return null;
    }

    public P dequeue() {
        return trajectoryQueue.removeFirst();
    }

    public P peek() {
        return trajectoryQueue.peek();
    }

    public int size() {
        return trajectoryQueue.size();
    }

    public boolean isEmpty() {
        return trajectoryQueue.isEmpty();
    }

    public String getAbsPath() {
        return absPath;
    }

    public String toString() {
        return null;
    }

    public static void main(String[] args) {
        TrajectoryQueue ok = new TrajectoryQueue("path_one.json");

    }
}

/**
 * class TrajectoryDeserializer {
 * String trajectoryTypeElement;
 * <p>
 * TrajectoryDeserializer(String trajectoryTypeElement) {
 * this.trajectoryTypeElement = trajectoryTypeElement;
 * }
 * <p>
 * public
 * }
 **/