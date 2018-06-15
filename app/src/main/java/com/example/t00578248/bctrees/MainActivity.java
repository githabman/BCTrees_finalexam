package com.example.t00578248.bctrees;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Tree> treeArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        treeArrayList = new ArrayList<>();
        GridView gridView = findViewById(R.id.treeGrid);


        try {
            JSONObject trees = new JSONObject(loadJSONFromAsset("trees"));
            JSONArray treeArray = trees.getJSONArray("trees");


             for (int i=0; i<treeArray.length(); i++){
                JSONObject tree = treeArray.getJSONObject(i);
                Log.v("potato","got tree"+ tree.getString("common_name"));
                Tree singleTree = new Tree();
                singleTree.commonName = tree.getString("common_name");
                singleTree.scientificName = tree.getString("scientific_name");
                singleTree.largeImage = getApplicationContext().getResources().
                        getIdentifier(tree.getString("image") + "_big",
                                "drawable",getApplicationContext().getPackageName());

                singleTree.smallImage = getApplicationContext().getResources().
                         getIdentifier(tree.getString("image") + "_small",
                                 "drawable",getApplicationContext().getPackageName());


                treeArrayList.add(singleTree);
            }
        } catch (JSONException e){
            e.printStackTrace();

        }
        Log.v("potato","Size of tree array list is: "+ treeArrayList.size());
        TreeAdapter treeAdapter = new TreeAdapter(treeArrayList, getApplicationContext());

        gridView.setAdapter(treeAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"I am "+ treeArrayList.get(position).scientificName, Toast.LENGTH_LONG).show();
                Intent intent= new Intent(MainActivity.this, DescriptionActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
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
