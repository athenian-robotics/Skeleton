package frc.team852.lib.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
}

