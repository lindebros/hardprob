package com.company;

import java.util.ArrayList;
import java.util.List;

import static com.company.FileReader.read;
import static com.company.FindMFMST.findMFMST;

public class Main {

    private static String FILENAME = "test01.uwg";

    public static List<Vertex> vertices;
    public static List<Edge> edges;

    public static List<Edge> mst;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        try {
            if (args.length > 0) {
                FILENAME = args[0];
            }
        }catch (Exception e){
        }
        // initialize  vertex and edge array.
        vertices = new ArrayList<>();
        edges = new ArrayList<>();

        read(FILENAME,edges,vertices); // read file.

        mst = findMFMST(edges,vertices.size()-1); // find Mirror Friendly Minimum Spanning Tree.

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Total running time: " +totalTime);

    }




}
