package com.company;

import java.util.ArrayList;
import java.util.List;

import static com.company.FileReader.read;
import static com.company.Subsets2.findSubsets;

public class Main {

    private static String FILENAME = "test03.uwg";

    public static List<Vertex> vertices;
    public static List<Edge> edges;

    public static List<Edge> mst;

    public static void main(String[] args) {
        try {
            FILENAME = args[0] + ".uwg";
        }catch (Exception e){
        }

        vertices = new ArrayList<>();
        edges = new ArrayList<>();

        read(FILENAME,edges,vertices);

        List<List<Edge>> subsets;
        mst = findSubsets(edges,vertices.size()-1);

        for (Edge e : mst){
            System.out.print(e.getA().getNumber() + "-" + e.getB().getNumber() + " : ");
        }

//        TGraph g = new TGraph(vertices.size());
//        g.read_CCGraph(subsets.get(0));
//        g.print_CCGraph();
//        boolean flag = false;
//        if (g.nedges == g.nvertices - 1)
//        {
//            flag = true;
//            if (connected_components(g) == 1 && flag == true)
//            {
//                System.out
//                        .println("Graph is a Tree, as graph is connected and Euler's criterion is satisfied.");
//            }
//        }
//        else
//        {
//            System.out
//                    .println("Graph is not a Tree, as Euler's criterion is not satisfied");
//        }

    }




}
