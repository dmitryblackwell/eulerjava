package com.blackwell.level_01;

public class Problem_006 {
    public Problem_006() {
        int SumOfSquares = 0;
        int SquareOfSum = 0;

        for(int i=1; i<=100; ++i)
            SumOfSquares += i*i;

        for(int i=1; i<=100; ++i)
            SquareOfSum += i;
        SquareOfSum*=SquareOfSum;
        System.out.println(SquareOfSum-SumOfSquares);
    }
}
