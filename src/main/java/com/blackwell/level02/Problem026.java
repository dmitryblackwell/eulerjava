package com.blackwell.level02;

import java.util.HashMap;

public class Problem026 {
    private static final int DECORATOR_LENGTH = 4;
    private String getInfinityCycle(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
           return res.toString();
        }

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }


    public Problem026() {
        int maxCycle = 0;
        int d=0;
        for (int i=2; i <= 1000; ++i) {
            int cycleLength = getInfinityCycle(1, i).length() - 4;
            if (cycleLength > maxCycle) {
                maxCycle = cycleLength;
                d = i;
            }
        }
        System.out.println(d);
    }

}
