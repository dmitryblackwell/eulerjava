package com.blackwell.level_01;

public class Problem_009 {
    public Problem_009() {
        int c,sum,finalNum = 1000;
        for(int i =1;i<finalNum;i++){
           for(int j=1;j<finalNum;j++){
               double resultTmp=Math.sqrt(i*i+j*j);
               if (resultTmp%1 == 0) {
                   c = (int) resultTmp;
                   sum = i + j + c;
                   if (sum == finalNum){
                       System.out.println(i+"^2 + "+j+"^2 = "+c+"^2   -=>"+sum+"______"+i*j*c);
                       break;
                   }
               }
           }
        }
    }
}
