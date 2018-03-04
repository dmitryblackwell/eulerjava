package com.blackwell.level_01;

public class Problem_012 {
    private int findDivisorsLength(long num){
        int DivisorsCount=2;
        for(int i=2;i<=Math.sqrt(num);++i){
            if (num%i == 0){
                DivisorsCount += (num/i == i)? 1:2;
                /*
                if (num/i == i)
                    System.out.print(i+" ");
                else
                    System.out.print(i+" "+num/i+" ");
                    */
            }
        }
        return DivisorsCount;
    }
    public Problem_012() {
        int triangleNumber=1;
        for (int i=2; findDivisorsLength(triangleNumber) <= 500; ++i){
            triangleNumber+=i;
        }
        System.out.println(triangleNumber);
    }
}
