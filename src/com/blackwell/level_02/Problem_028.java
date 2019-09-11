package com.blackwell.level_02;

public class Problem_028 {

    private static final int SIZE = 1001;
    private static final int DIFF_BETWEEN_CYCLE = 2;

    public Problem_028() {
        int sum = 1;
        int diff = DIFF_BETWEEN_CYCLE;
        int count = 0;
        for (int i=3; count/4 != SIZE/2 ; i += diff) {
            sum += i;
            count++;
            if (count%4 == 0)
                diff += DIFF_BETWEEN_CYCLE;
        }
        System.out.println(sum);
    }
}
