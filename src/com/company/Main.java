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
        }

        vertices = new ArrayList<>();
        edges = new ArrayList<>();

        read(FILENAME,edges,vertices);
        System.out.println("Edges: " + edges.size());

        List<List<Edge>> subsets;
        subsets = getSubsets(edges,vertices.size()-1);

        for (List<Edge> s:subsets){
            for (Edge e : s){
                System.out.print(e.getA().getNumber() + "-" + e.getB().getNumber() + " : ");
            }
            System.out.println();
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
