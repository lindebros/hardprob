package com.company;

import javax.xml.stream.events.EndElement;
import java.util.ArrayList;
import java.util.List;

import static com.company.CheckUndirectedGraphisTree.connected_components;

/**
 * Created by Mikkel on 05/11/2017.
 */
public class FindMFMST {

    private static List<Edge> mst = null;
    private static int minSum = Integer.MAX_VALUE;
    private static int nvertices;

    public static List<Edge> findMFMST(List<Edge> input, int k) {

        nvertices = k+1;

        int max = binomialCoeff(input.size(),k);    // Total amount of subsets of size k ( number of vertices - 1 )
        int done = 0;                               // Used to keep track of how far the algorithm is.

        // here we'll keep indices pointing to elements in input array
        int[] s = new int[k];

        if (k <= input.size()) {
            // first index sequence: 0, 1, 2, ...
            for (int i = 0; (s[i] = i) < k - 1; i++);
            getSubset(input,s);
            done++;
            for(;;) {
                int i;
                // find position of item that can be incremented
                for (i = k - 1; i >= 0 && s[i] == input.size() - k + i; i--);
                if (i < 0) {
                    break;
                }
                s[i]++;                    // increment this item
                for (++i; i < k; i++) {    // fill up remaining items
                    s[i] = s[i - 1] + 1;
                }
                getSubset(input,s);
                done++;
            }
        }
        System.out.println("Found B: " + minSum);
        return mst;
    }

    private static boolean isTree(List<Edge> input, List<Edge> subset){
        // Get the subset, and see if it is a spanning tree.
        TGraph g = new TGraph(nvertices);
        g.read_CCGraph(subset);
        boolean flag = false;
        if (g.nedges == g.nvertices - 1)
        {
            flag = true;
            if (connected_components(g) == 1 && flag == true)
            {
                return true;
            }
            return false;

        }
        else
        {
            return false;
        }

    }


    // generate actual subset by index sequence
    static void getSubset(List<Edge> input, int[] subset) {
        List<Edge> result = new ArrayList<>();
        int stSum = 0;          // Spanning tree weight sum
        int mirSum = 0;         // Mirror weight sum
        int localMin = 0;

        for (int i = 0; i < subset.length; i++)
            result.add(input.get(subset[i]));

        for (Edge e: result){
            stSum += e.getWeight();
        }
        for (int i = 0; i< subset.length; i++){
            int index = input.size() - 1 - subset[i];          // mirrored edge's index.
            mirSum += input.get(index).getWeight();
        }
        // Finding local minimum of either spanning tree or mirror.
        if (stSum > mirSum){
            localMin = stSum;
        }else{
            localMin = mirSum;
        }

        if (localMin < minSum ){ // Is a spanning tree; now to check if it is the minimum spanning tree
            if (isTree(input, result)) {
                minSum = localMin;
                mst = result;
            }
        }
    }
    // Returns value of Binomial Coefficient C(n, k)
    static int binomialCoeff(int n, int k)
    {
        int res = 1;

        // Since C(n, k) = C(n, n-k)
        if ( k > n - k )
            k = n - k;

        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; ++i)
        {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

}
