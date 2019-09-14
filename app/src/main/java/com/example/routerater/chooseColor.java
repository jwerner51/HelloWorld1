package com.example.routerater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class chooseColor extends AppCompatActivity {

    ListView tapeColorsList;
    List tapeColors = new ArrayList();

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_color);

        tapeColorsList = (ListView)findViewById(R.id.tapeColorsList);

        tapeColors.add("Purple");
        tapeColors.add("Blue");
        tapeColors.add("Green");
        tapeColors.add("Yellow");

        adapter = new ArrayAdapter(chooseColor.this, android.R.layout.simple_list_item_1, tapeColors);
        tapeColorsList.setAdapter(adapter);

    }
}
