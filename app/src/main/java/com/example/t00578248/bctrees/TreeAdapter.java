package com.example.t00578248.bctrees;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by t00578248 on 6/12/2018.
 */

public class TreeAdapter extends BaseAdapter {


    ArrayList<Tree> treeArrayList;
    private Context context;

    public TreeAdapter(ArrayList trees, Context c){
        treeArrayList =trees;
        context =c;
    }

    @Override
    public int getCount() {
        return treeArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(500,500));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        }else{
            imageView = (ImageView)view;
        }
        imageView.setImageResource(treeArrayList.get(i).smallImage);
        return imageView;
    }
}
