package com.example.routerater;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class DatabaseAccess {
    FirebaseFirestore db;

    public DatabaseAccess() {
        this.db = FirebaseFirestore.getInstance();
    }

    public void insertRating(String color, String route, int rating) {
        DocumentReference colorRef = db.collection("colors").document(color);
        DocumentReference routeRef = colorRef.collection("routes").document(route);
        routeRef.update("ratings", FieldValue.arrayUnion(rating));
    }

    public Color[] getColors(){
        final ArrayList<Color> colorsList = new ArrayList<>();
        db.collection("colors").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot color : task.getResult()) {
                        colorsList.add(new Color((String)color.get("name"), color.getId()));
                    }
                }
            }
        });
        return colorsList.toArray(new Color[]{});
    }

    public Route[] getRoutes(Color color){
        final ArrayList<Route> routesList = new ArrayList<>();
        db.collection("colors").document(color.id).collection("routes").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot route : task.getResult()) {
                        routesList.add(new Route((String)route.get("name"), route.getId(),(int[])route.get("ratings")));
                    }
                }
            }
        });
        return routesList.toArray(new Route[]{});
    }
}
