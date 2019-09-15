package com.example.routerater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;


public class ColorPickerActivity extends AppCompatActivity {

    DatabaseAccess db = new DatabaseAccess();
    Color[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        colors = db.getColors();

        // Get reference of widgets from XML layout
        View view = LayoutInflater.from(ColorPickerActivity.this).inflate(R.layout.activity_color_picker, null, false);
        final ListView colorsListView = view.findViewById(R.id.colorsList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ColorPickerActivity.this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        for (Color color: colors) {
            adapter.add(color.name);
        }
        colorsListView.setAdapter(adapter);

//
//
//        String[] buttonNamesArray = new String[colorsLength];   //List of button names
//        String[] buttonIDArray = new String[colorsLength];      //List of button IDs
//        Color[] colorsArray = db.getColors();                   //List of color objects
//
//        Button[] buttonArray = new Button[colorsLength];
//
//        for (int i = 0; i < colorsLength; i++) {        //Go through all color objects
//            buttonNamesArray[i] = colorsArray[i].name;
//            buttonIDArray[i] = colorsArray[i].id;
//
//            buttonArray[i] = (Button)findViewById(R.id.);
//        }

    }



}
