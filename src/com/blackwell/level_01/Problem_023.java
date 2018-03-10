package com.blackwell.level_01;

public class Problem_023 {
    private static final int GREATEST_NUM = 28123;

    private int getSumDivisors(int n){
        int sum=1;
        for(int i=2; i<Math.sqrt(n); ++i)
            if(n%i == 0)
                sum += (n/i == i) ? i : (i+ n/i);
        return sum;
    }

    private boolean isAbundant(int n){
        return getSumDivisors(n)>n;
    }

    private boolean canBeWrittenAsSum(int n){
        for(int i=0; i<n; ++i){
            if (isAbundant(i) && isAbundant(n-i))
                return true;
        }
        return false;
    }

    public Problem_023() {
        int sum=0;
        for(int i=0; i < GREATEST_NUM; ++i) {
            if (!canBeWrittenAsSum(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
