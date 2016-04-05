package com.example.zhu2067.modelunnew;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DataModel {
    private ArrayList<Conference> conferencesArray = new ArrayList<Conference>();
    private Context ctx;

    private static  String TAG = "DataModel";

    // Initializer to read a text file into an array of Conference objects
    public DataModel(Context ctx, String conferencesFilename) {
        String line;
        BufferedReader br;

        try {
            br = new BufferedReader(new InputStreamReader(ctx.getAssets().open(conferencesFilename)));

            while ((line = br.readLine()) != null) {
                StringTokenizer sTok = new StringTokenizer(line, ":");
                Conference gc = new Conference(sTok.nextToken());
                gc.address = sTok.nextToken();
                conferencesArray.add(gc);
            }
        } catch (IOException e) {
            return;
        }
    }

    // Method to retrieve conferences
    public ArrayList<Conference> getCourses() {
        return conferencesArray;
    }
}
