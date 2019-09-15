package com.example.routerater;

public class Route {
    String name;
    String id;
    int[] ratings;

    public Route(String name, String id, int[] ratings) {
        this.name = name;
        this.id = id;
        this.ratings = ratings;
    }
}
