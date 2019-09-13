package com.blackwell.level01;

public class Problem021 {
    public int findDivisorsSum(int n){
        int sum=1; //because there are already count in number and 1
        for(int i=2; i<Math.sqrt(n); ++i)
            if(n%i == 0)
                sum += (i == (n / i)) ? i : (i + n / i);
        return sum;
    }
    private boolean isAmicableNumber(int num){
        int dFromA = findDivisorsSum(num);
        int dFromB = findDivisorsSum(dFromA);
        return (dFromB == num) && dFromA != dFromB;
    }

    public Problem021() {
        int sum=0;
        for (int i=0; i<10_000; ++i){
            if (isAmicableNumber(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
