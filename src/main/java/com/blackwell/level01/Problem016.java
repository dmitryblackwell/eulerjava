package com.blackwell.level01;

import java.math.BigInteger;

public class Problem016 {
    public Problem016() {
        BigInteger num=new BigInteger("1");
        for(int i=0;i<1_000;++i)
            num = num.multiply(new BigInteger("2"));
        String strNum=num.toString();
        int sum=0;
        for(int i=0;i<strNum.length();++i)
            sum += Integer.parseInt(String.valueOf(strNum.charAt(i)));
        System.out.println(sum);
    }
}
