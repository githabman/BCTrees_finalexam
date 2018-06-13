package com.example.t00578248.bctrees;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JSONObject trees = new JSONObject(loadJSONFromAsset("trees"));
            JSONArray treeArray = trees.getJSONArray("trees");


             for (int i=0; i<treeArray.length(); i++){
                JSONObject tree = treeArray.getJSONObject(i);
                Log.v("potato","got tree"+ tree.getString("common_name"));

            }
        } catch (JSONException e){
            e.printStackTrace();

        }
    }

    public String loadJSONFromAsset(String filename){
        String json ="";
        try{
            InputStream is =getAssets().open(filename +".json");
            int size = is.available();
            byte [] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
        return json;

    }

}
