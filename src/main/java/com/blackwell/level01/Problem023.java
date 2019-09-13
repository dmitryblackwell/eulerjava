package com.blackwell.level01;

public class Problem023 {
    private static final int LIMIT = 28_123;
    private boolean[] isAbundant = new boolean[LIMIT];

    private int findDivisionSum(int n){
        int sum=1;
        for(int i=2; i<=Math.sqrt(n); ++i)
            if (n%i == 0)
                sum += (n/i == i) ? i : (n/i + i);
        return sum;
    }
    private void AbundantInit(){
        for(int i=0; i<isAbundant.length; ++i)
            isAbundant[i] = findDivisionSum(i) > i;
    }
    private boolean doubleSumCheck(int n){//can be written as the sum of two abundant numbers.
        for(int i=1; i<n; ++i)
            if(isAbundant[i] && isAbundant[n-i])
                return true;
        return false;
    }
    public Problem023() {
        AbundantInit();
        int sum=0;
        for (int i=0; i<LIMIT; ++i)
            if (! doubleSumCheck(i))
                sum += i;
        System.out.println(sum);
    }
}
