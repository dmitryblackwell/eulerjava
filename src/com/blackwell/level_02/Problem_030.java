package com.blackwell.level_02;

public class Problem_030 {

    int getSumOfFifth(int num) {
        int sum = 0;
        while (num != 0) {
            sum += Math.pow(num%10, 5);
            num /= 10;
        }
        return sum;
    }

    public Problem_030() {
        int sum = 0;
        for(int i=10_000; i<100_000; ++i)
            if (getSumOfFifth(i) == i)
                sum += i;
        System.out.println(sum);
    }
}
