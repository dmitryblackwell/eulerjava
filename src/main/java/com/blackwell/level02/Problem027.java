package com.blackwell.level02;

import com.blackwell.Utils;

public class Problem027 {

    private int getMaxPrime(int a, int b) {
        for (int i=0; i<1000; ++i) {
            int res = i*i + a*i + b;
            if (!Utils.isPrime(res)) {
                return i;
            }
        }
        return 0;
    }

    public Problem027() {
        int max = 0;
        int ab = 0;
        for(int a=-999; a<1000; ++a) {
            for (int b=-999; b<1000; ++b) {
                if (getMaxPrime(a, b) > max) {
                    max = getMaxPrime(a, b);
                    ab = a * b;
                }
            }
            System.out.println(a);
        }
        System.out.println(ab);
    }
}
