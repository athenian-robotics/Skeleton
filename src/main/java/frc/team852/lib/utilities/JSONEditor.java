package frc.team852.lib.utilities;

import org.json.*;
import java.io.*;

import java.io.File;

public final class JSONEditor {

    private static final String systemPath; // from root to generated_path, no file
    private static final String workingPath = "/src/main/java/frc/team852/lib/utilities/generated_path/";
    private static String filename; //name
    private static String relativePath; // relative path
    private static String absPath; // absolute path

    public IPose2D pose = null;

    static {
        // set default static file name as test, so it no break and save it to something
        filename = "test.json";
        relativePath = workingPath + filename;
        systemPath = (new File("./")).getAbsoluteFile() + workingPath;
        absPath = systemPath + filename;
    }

    public static boolean dumpJSON() {
        // TODO Donovan implement JSON
        JSONArray jPose = new JSONArray();

        return Boolean.parseBoolean(null);
    }

    public static void clear() {

    }


    public static boolean setName(String name) {
        if (checkFile(name)) return false;
        else {
            filename = name;
            relativePath = workingPath + filename;
            absPath = systemPath + filename;
        }
        return true;
    }

    public static boolean checkFile(String name) {
        return (new File (systemPath + name).exists());
    }

    class Getter {
        public String filename() {
            return filename;
        }

        public String absolutePath() {
            return absPath;
        }

        public IPose2D prevPose() {
            return pose;
        }
    }


    // TESTING WILL DELETE
    public static void main(String args[]) {
        JSONEditor.setName("path_one.json");
        Getter getter = new JSONEditor().new Getter();
        System.out.println(getter.filename());
        Pose2D ok = new Pose2D();
        Pose2DWithCurvature ok1 = new Pose2DWithCurvature(1, 2,3);
        JSONEditor.dumpJSON(ok1);
        //System.out.println(JSONDump.getFilename());
        //System.out.println(JSONDump.getAbsolutePath());
    }
}
