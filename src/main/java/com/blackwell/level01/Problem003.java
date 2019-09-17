package com.blackwell.level01;

import com.blackwell.Utils;

import java.math.BigInteger;
import java.util.Random;

public class Problem003 {

    private long findMaxPrimeNumber(long startNum){
        for (int i =2;true;++i){
            if (startNum%i == 0 && Utils.isPrime(startNum/i))
                return startNum/i;
        }
    }
    public Problem003() {
        long startNum=Long.parseUnsignedLong("600851475143");
        System.out.println(findMaxPrimeNumber(startNum));
    }
}
