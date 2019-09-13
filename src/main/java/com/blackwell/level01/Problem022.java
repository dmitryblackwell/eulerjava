package com.blackwell.level01;

import java.io.*;
import java.util.Arrays;

public class Problem022 {
    private static final String FILE_NAME = "src/com/blackwell/data/p022_names.txt";
    private static final int CHAR_SHIFTING = 64;
    private String[] names;

    private void NamesArrayInit(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            String getLine = br.readLine().replace("\"","");
            names = getLine.split(",");
            Arrays.sort(names);
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private int getAlphabeticalValue(int nameNum){
        int AlphabeticalValue = 0;
        for(int i=0; i<names[nameNum].length(); ++i)
            AlphabeticalValue += ((int) names[nameNum].charAt(i)) - CHAR_SHIFTING;
        AlphabeticalValue *= ++nameNum;
        return AlphabeticalValue;
    }
    public Problem022() {
        NamesArrayInit();
        int score=0;
        for(int i = 0; i<names.length; ++i)
            score += getAlphabeticalValue(i);
        System.out.println(score);
    }
}
