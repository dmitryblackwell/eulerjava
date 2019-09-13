package com.blackwell.level01;


import java.util.ArrayList;
import java.util.Collections;

public class Problem024 {
    private ArrayList<String> permutes = new ArrayList<>();
    private void permute(String prefix, String remaining){
        if (remaining.length() == 0) {
            //System.out.println(prefix);
            permutes.add(prefix);
            return;
        }
        for (int i=0; i<remaining.length(); ++i){
             permute(prefix+remaining.charAt(i),
                     remaining.substring(0,i) + remaining.substring(i+1,remaining.length()));
        }
    }

    private void permute(String remaining){
        permute("",remaining);
    }

    public Problem024() {
        String start = "0123456789";
        permute(start);
        Collections.sort(permutes);
        System.out.println(permutes.get(1_000_000-1));
    }

}
