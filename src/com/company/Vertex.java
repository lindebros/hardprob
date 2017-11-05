package com.company;

import java.util.List;

public class Vertex {
    List<Edge> connections;
    private int number;

    Vertex(int number){
        this.number = number;
    }

    public void addEdge(Edge e){
        connections.add(e);
    }

    public int getNumber() {
        return number;
    }
}
