package com.company;

import java.util.*;

class TGraph
{
    static final int MAXV      = 100;
    static final int MAXDEGREE = 50;
    public int       edges[][] = new int[MAXV + 1][MAXDEGREE];
    public int       degree[]  = new int[MAXV + 1];
    public int       nvertices;
    public int       nedges;

    TGraph(int nvertices)
    {
        edges= new int[nvertices + 1][nvertices];
        degree = new int[nvertices + 1];

        this.nvertices = nvertices;
        for (int i = 1; i <= nvertices; i++)
            degree[i] = 0;
    }

    void read_CCGraph(List<Edge> edges)
    {
        int x, y;
        for (int i = 0; i < edges.size(); i++)
        {
            //Adds edge between vertex x and y
            x = edges.get(i).getA().getNumber();
            y = edges.get(i).getB().getNumber();
            insert_edge(x, y,false);
        }
    }

    void insert_edge(int x, int y,boolean directed)
    {
        edges[x][degree[x]] = y;
        degree[x]++;
        if (!directed){
            insert_edge(y,x,true);
        }else {
            nedges++;
        }
    }

    void print_CCGraph()
    {
        for (int i = 1; i <= nvertices; i++)
        {
            System.out.printf("%d: ", i);
            for (int j = degree[i] - 1; j >= 0; j--)
                System.out.printf(" %d", edges[i][j]);
            System.out.printf("\n");
        }
    }
}

public class CheckUndirectedGraphisTree
{
    static int MAXV         = 100;
    static boolean   processed[]  = new boolean[MAXV];
    static boolean   discovered[] = new boolean[MAXV];
    static int       parent[]     = new int[MAXV];

    CheckUndirectedGraphisTree(int nvertices){
        MAXV = nvertices;
        processed = new boolean[MAXV];
        discovered = new boolean[MAXV];
        parent   = new int[MAXV];
    }

    static void bfs(TGraph g, int start)
    {
        Queue<Integer> q = new LinkedList<>();
        int i, v;
        q.offer(start);
        discovered[start] = true;
        while (!q.isEmpty())
        {
            v = q.remove();
            // process_vertex(v);
            processed[v] = true;
            for (i = g.degree[v] - 1; i >= 0; i--)
            {
                if (!discovered[g.edges[v][i]])
                {
                    q.offer(g.edges[v][i]);
                    discovered[g.edges[v][i]] = true;
                    parent[g.edges[v][i]] = v;
                }
            }
        }
    }

    static void initialize_search(TGraph g)
    {
        for (int i = 1; i <= g.nvertices; i++)
        {
            processed[i] = discovered[i] = false;
            parent[i] = -1;
        }
    }

    static void process_vertex(int v)
    {
        System.out.printf(" %d", v);
    }

    static int connected_components(TGraph g)
    {
        int c;
        initialize_search(g);
        c = 0;
        for (int i = 1; i <= g.nvertices; i++)
        {
            if (!discovered[i])
            {
                c++;
                // System.out.printf("Component %d:", c);
                bfs(g, i);
                // System.out.printf("\n");
            }
        }
        return c;
    }


}