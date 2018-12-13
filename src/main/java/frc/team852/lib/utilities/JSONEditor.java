package frc.team852.lib.utilities;

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
        System.out.println(absPath);
        FileWriter file = new FileWriter(absPath);

        try {
            file.write(jw.toJSON());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.flush();
            file.close();
        }
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

    public static void main(String[] args) throws IOException {

        JSONEditor.setName("path_one.json");
        Pose2D ok = new Pose2D();
        Pose2D okok = new Pose2D();
        Pose2D okokok = new Pose2D();

        Trajectory<Pose2D> okokokok = new Trajectory<>();
        okokokok.add(ok);
        okokokok.add(okok);
        okokokok.add(okokok);

        System.out.println(okokokok.toJSON());

        JSONEditor.dumpJSON(okokokok);


    }
}

