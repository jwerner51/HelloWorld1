package com.example.routerater;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

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
}
