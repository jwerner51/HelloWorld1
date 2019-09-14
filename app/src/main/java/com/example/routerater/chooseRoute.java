package com.example.routerater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class chooseRoute extends AppCompatActivity {

    ListView routeChoicesList;
    List routeChoiceItems = new ArrayList();

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_route);

        routeChoicesList = (ListView)findViewById(R.id.routeChoices);

        routeChoiceItems.add("hello");
        routeChoiceItems.add("world");
        routeChoiceItems.add("plus");
        routeChoiceItems.add("some");
        routeChoiceItems.add("more");
        routeChoiceItems.add("text");

        adapter = new ArrayAdapter(chooseRoute.this, android.R.layout.simple_list_item_1, routeChoiceItems);
        routeChoicesList.setAdapter(adapter);
    }
}
