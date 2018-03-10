package com.blackwell.level_01;

import java.util.ArrayList;

public class Problem_023 {
    private static final int GREATEST_NUM = 28123;
    private boolean[] isAbundant = new boolean[GREATEST_NUM];
    private boolean[] isSumOfTwoAbundants = new boolean[GREATEST_NUM+1];
    private int getSumDivisors(int n){
        int sum=1;
        for(int i=2; i<Math.sqrt(n); ++i)
            if(n%i == 0)
                sum += (n/i == i) ? i : (i+ n/i);
        return sum;
    }

    private boolean isAbundant(int n){
        return n > 11 && getSumDivisors(n)>n;
    }
    private void AbundantInit(){
        for(int i=1; i < GREATEST_NUM; ++i)
            isAbundant[i] = isAbundant(i);
    }
    private void SumOfTwoAbundantsInit(){
        for(int i=0; i<isSumOfTwoAbundants.length; ++i)
            isSumOfTwoAbundants[i] = false;

        for(int i=0; i<isSumOfTwoAbundants.length; ++i){
            for(int j=i; j<isSumOfTwoAbundants.length; ++j){
                if( i+j < GREATEST_NUM && isAbundant[i] && isAbundant[j] )
                    isSumOfTwoAbundants[i+j] = true;
            }
        }
    }

    private boolean canBeWrittenAsSum(int n){
        for(int i=1; i<=n; ++i)
            if (isAbundant[i] && isAbundant[n-i])
                return true;
        return false;
    }

    public Problem_023() {
        AbundantInit();
        SumOfTwoAbundantsInit();
        int sum=0;
        for(int i=1; i <= GREATEST_NUM; ++i) {
            if (isSumOfTwoAbundants[i]) {
                sum += i;
                //System.out.println(i);
            }
        }
        System.out.println(sum);
    }
}
