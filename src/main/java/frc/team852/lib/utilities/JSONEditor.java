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


    static {
        // set default static file name as test, so it no break and save it to something
        filename = "test.json";
        relativePath = workingPath + filename;
        systemPath = (new File("./")).getAbsoluteFile() + workingPath;
        absPath = systemPath + filename;
    }



    public static void dumpJSON(JSONWritable jw) throws IOException {
        // TODO Donovan implement JSON
        // if (!checkFile(filename)) return false;
        FileWriter file = new FileWriter(absPath);
        file.write(jw.toJSON());
    }

    public static void setName(String name) {
        filename = name;
        relativePath = workingPath + filename;
        absPath = systemPath + filename;
    }

    public String filename() {
            return filename;
    }

    public String absolutePath() {
            return absPath;
    }

    // TESTING WILL DELETE
    public static void main(String args[]) throws IOException {
        //JSONEditor.setName(");
        Pose2D ok = new Pose2D();
        JSONEditor.dumpJSON(ok);
        // Pose2DWithCurvature ok1 = new Pose2DWithCurvature(1, 2,3);
        //System.out.println(JSONDump.getFilename());
        //System.out.println(JSONDump.getAbsolutePath());
    }
}
