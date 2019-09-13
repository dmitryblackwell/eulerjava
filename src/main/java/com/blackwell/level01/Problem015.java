package com.blackwell.level01;

import java.math.BigInteger;

public class Problem015 {
    private static final int x=20,y=20;

    private BigInteger factorial(int n){
        BigInteger f = new BigInteger("1");
        for(int i=0; i<n; ++i)
            f= f.multiply(BigInteger.valueOf(n-i));
        return f;
    }
    public Problem015() {
        BigInteger result = factorial(x+y)
                .divide( factorial(x).multiply(factorial(y)) );
        //easy to say (x+y)! / x!y!
        System.out.println(result);
    }
}
//1 -> 2
//2 -> 6
//3 -> 20
//4 -> 70
//...
//20 -> 137846528820