package com.example.t00578248.bctrees;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    private int position = 0;
    private TextView commonText;
    private TextView scientificText;
    private TextView descriptionText;
    private ImageView bigImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intent= getIntent();
        if(intent !=null){
            position = intent.getExtras().getInt("position");

        }
        commonText = findViewById(R.id.commontext);
        scientificText= findViewById(R.id.scientifictext);
        descriptionText= findViewById(R.id.descriptiontext);
        bigImage=findViewById(R.id.imageView);

        Tree tree = MainActivity.treeArrayList.get(position);

        commonText.setText(tree.commonName);
        scientificText.setText(tree.scientificName);
        //descriptionText.setText();
        bigImage.setImageResource(tree.largeImage);
    }
}
