package com.blackwell.level_01;

import java.math.BigInteger;

public class Problem_020 {
    private BigInteger factorial(BigInteger n){
        if (n.equals(BigInteger.valueOf(0)))
            return BigInteger.valueOf(1);
        return n.multiply(factorial(n.add(BigInteger.valueOf(-1))));
    }
    public Problem_020() {
        String result = factorial(BigInteger.valueOf(100)).toString();
        //System.out.println(result);
        int sum=0;
        for(int i=0; i<result.length(); ++i)
            sum += Integer.parseInt(String.valueOf(result.charAt(i)));
        System.out.println(sum);
    }
}
