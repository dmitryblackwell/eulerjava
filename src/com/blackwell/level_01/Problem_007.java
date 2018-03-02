package com.blackwell.level_01;

import java.util.Arrays;

public class Problem_007 {
    private boolean[] primes = new boolean[1_000_000];
    private void fillPrimes(){
        Arrays.fill(primes,true);
        primes[0]=primes[1]=false;
        for(int i = 0;i<primes.length;++i){
            if(primes[i])
                for (int j=2;i*j<primes.length;++j)
                    primes[i*j]=false;
        }
    }

    public Problem_007() {
        fillPrimes();
        int primesCount=0;
        for(int i=0;i<primes.length;++i){
            if (primes[i])
                primesCount++;
            if (primesCount == 10_001){
                System.out.println(i);
                break;
            }
        }
    }
}
