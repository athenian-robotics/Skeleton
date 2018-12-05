package frc.team852.lib.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class JSONParser implements JSONWritable {
    private final String fileName;
    JSONParser(String name) {
        fileName = name;
    }

    @Override
    public void dumpJSON() {

    }
}
