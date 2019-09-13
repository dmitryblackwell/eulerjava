package com.blackwell.level01;

import java.util.Arrays;

public class Problem010 {
    private boolean isPrime(int num){ //Wilson's theorem, but it is to slow
        int fac = 1;
        for (int i=1;i<num;++i){
            fac = (fac * i) % num;
        }
        return  fac == num-1;
    }

    private static final int maxCount=2_000_000;
    private boolean[] primes = new boolean[maxCount];
    private void fillPrimes(){
        Arrays.fill(primes,true);
        primes[0]=primes[1]=false;
        for(int i = 0;i<primes.length;++i){
            if(primes[i])
                for (int j=2;i*j<primes.length;++j)
                    primes[i*j]=false;
        }
    }


    public Problem010() {
        fillPrimes();
        long sum=0;
        for(int i=1;i<maxCount;++i){
            sum+= primes[i] ? i:0;
        }
        System.out.println(sum);
    }

}