package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.company.Subsets.getSubsets;

public class Main {

    public static void main(String[] args) {
        List<Integer> superSet = new ArrayList<>();
        for (int i = 1 ; i <= 30; i++){
            superSet.add(i);
        }
        System.out.println(getSubsets(superSet,5));
    }


}
