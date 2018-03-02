package com.blackwell.level_01;

import java.util.Random;

public class Problem_009 {
    public Problem_009() {
        float c,sum,finalNum = 1000;
        //while (sum != finalNum){
        for(float i =0;i<Math.sqrt(finalNum);i+=0.1){
           for(float j=0;j<Math.sqrt(finalNum);j+=0.1){
               c=i*i+j*j;
               sum=i+j+c;
               if (sum == finalNum){
                   break;
               }
                if( sum+1 < finalNum+2 && sum-1>finalNum-2)
               System.out.println(i+"^2 + "+j+"^2 = "+c+"^2   --"+sum);
           }
        }
    }
}
