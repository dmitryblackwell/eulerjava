package com.blackwell.level02;

public class Problem030 {

    private int getSumOfFifth(int num) {
        int sum = 0;
        while (num != 0) {
            sum += Math.pow(num%10, 5);
            num /= 10;
        }
        return sum;
    }

    public Problem030() {
        int sum = 0;
        for(int i=10_000; i<100_000; ++i)
            if (getSumOfFifth(i) == i)
                sum += i;
        System.out.println(sum);
    }
}
