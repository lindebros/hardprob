package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class FileReader {
    public static void read(String FILENAME, List<Edge> edges, List<Vertex> vertices){
        BufferedReader br = null;
        java.io.FileReader fr = null;

        try {
            fr = new java.io.FileReader(FILENAME);
            br = new BufferedReader(fr);

            String currentLine;
            if ((currentLine = br.readLine()) != null){
                for (int i = 0; i < Integer.parseInt(currentLine); i++){
                    vertices.add(new Vertex(i+1));
                }
            }
            // Skip the line that tells number of edges
            br.readLine();

            while ((currentLine = br.readLine()) != null){
                String[] parts = currentLine.split(" ");
                int index1 = Integer.parseInt(parts[0]);
                int index2 = Integer.parseInt(parts[1]);
                int value = Integer.parseInt(parts[2]);

                edges.add(new Edge(vertices.get(index1 - 1),vertices.get(index2 - 1),value));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
