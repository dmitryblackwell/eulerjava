package com.blackwell.level_01;

public class Problem_015 {
    private static final int num[][]=new int[20][20];
    public Problem_015() {
        for(int i=0;i<20;++i){
            for(int j=0;j<20;++j){
                num[i][j]=0;
                System.out.print(num[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
