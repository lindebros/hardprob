package com.company;

public class Edge {

    private Vertex a,b;
    private int weight;

    Edge(Vertex a, Vertex b, int weight){
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }

    public Vertex getA() {
        return a;
    }

    public Vertex getB() {
        return b;
    }
}
