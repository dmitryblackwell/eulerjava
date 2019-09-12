package com.blackwell.level_02;

import java.util.HashSet;
import java.util.Set;

public class Problem_029 {

    public Problem_029() {
        Set<Double> set = new HashSet<>();
        for(int i=2; i<=100; ++i)
            for(int j=2; j<=100; ++j)
                set.add(Math.pow(i,j));
        System.out.println(set.size());
    }
}
