package frc.team852.lib.utilities;

import org.json.*;
import java.io.*;

import java.io.File;

public final class JSONDump {

    private static String filename;

    static {
        // set default static file name as test, so it no break
        filename = "./generated_path/test.json";
    }

    public static boolean dumpJSON(String name) {
        // TODO Donovan implement JSON
        return Boolean.parseBoolean(null);
    }

    public static boolean setName(String name) {
        filename = name;
        File tmpFile = new File(filename);
        return tmpFile.exists();
    }


    // TESTING WILL DELETE
    public static void main(String args[]) {
        JSONDump wot = new JSONDump();
        Boolean check = (new File ((new File("./")).getAbsoluteFile() + "/src/main/java/frc/team852/lib/utilities/generated_path/test.json").exists());
        System.out.println(check);
    }
}
