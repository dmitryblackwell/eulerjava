package com.blackwell.level01;

public class Problem002 {
    public Problem002() {
        int sum=0;
        int privNum=1,privPrivNum=1;
        for(int i = 2;i< 4_000_000;i=privNum+privPrivNum){
            if (i%2 == 0)
                sum+=i;
            privPrivNum=privNum;
            privNum=i;
        }
        System.out.println(sum);
    }
}
