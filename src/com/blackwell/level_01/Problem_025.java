package com.blackwell.level_01;

import java.math.BigInteger;

public class Problem_025 {
    public Problem_025() {
        BigInteger F1= BigInteger.valueOf(1);
        BigInteger F2= F1;
        int count = 2;
        while (F2.toString().length() < 1_000){
            BigInteger bg = F1.add(F2);
            F1=F2;
            F2=bg;
            count++;
        }
        System.out.println(count);
    }
}
