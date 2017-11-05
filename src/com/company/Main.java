package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.company.Subsets.getSubsets;
import static com.company.FileReader.read;

public class Main {

    private static String FILENAME = "test01.uwg";

    public static List<Vertex> vertices;
    public static List<Edge> edges;

    public static void main(String[] args) {
        try {
            FILENAME = args[0] + ".uwg";
        }catch (Exception e){
            e.printStackTrace();
        }

        vertices = new ArrayList<>();
        edges = new ArrayList<>();

        read(FILENAME,edges,vertices);
        System.out.println("Edges: " + edges.size());

        List<Set<Edge>> subsets;
        subsets = getSubsets(edges,vertices.size()-1);

        for (Set<Edge> s:subsets){
            for (Edge e : s){
                System.out.print(e.getA().getNumber() + "-" + e.getB().getNumber() + " : ");
            }
            System.out.println();
        }


    }



}
