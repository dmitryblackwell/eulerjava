package com.blackwell;

import java.math.BigInteger;
import java.util.Random;

public class Utils {

    public static boolean isPrime(long num){ //Miller-Rabin primality test
        if (num < 2)
            return false;
        if (num < 4)
            return true;
        if (num%2 == 0)
            return false;

        long s= num-1;
        while (s%2 == 0)
            s/=2;

        Random rand=new Random();
        for (long i=0;i<num;++i){
            long r = Math.abs(rand.nextLong());
            long a = r % (num-1) + 1;
            long temp = s;
            long mod = modPow(a,temp,num);
            while (temp != num-1 &&
                    mod != 1 &&
                    mod != num-1){
                mod = mulMod(mod,mod,num);
                temp*=2;
            }
            if (mod != num-1 && temp%2 == 0)
                return false;
        }
        return true;
    }

    private static long modPow(long a,long b,long c){//Function to calculate (a ^ b) % c
        long res = 1;
        for (int i = 0; i < b; ++i){
            res *= a;
            res %= c;
        }
        return res%c;
    }

    private static long mulMod(long a,long b,long mod){ //Function to calculate (a * b) % c
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue();
    }
}
