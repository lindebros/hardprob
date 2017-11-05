package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
    private static void getSubsets(List<Edge> superSet, int k, int idx, List<Edge> current, List<List<Edge>> solution) {
        //successful stop clause
        if (current.size() == k) {
            solution.add(new ArrayList<>(current));
            return;
        }
        //unseccessful stop clause
        if (idx == superSet.size()) return;
        Edge x = superSet.get(idx);
        current.add(x);
        //"guess" x is in the subset
        getSubsets(superSet, k, idx+1, current, solution);
        current.remove(x);
        //"guess" x is not in the subset
        getSubsets(superSet, k, idx+1, current, solution);
    }

    public static List<List<Edge>> getSubsets(List<Edge> superSet, int k) {
        List<List<Edge>> res = new ArrayList<>();
        getSubsets(superSet, k, 0, new ArrayList<>(), res);
        return res;
    }
}
