package com.blackwell.level_01;

public class Problem_014 {
    private int getTermsCount(long startNumber){
        int termsCount=1;
        while (startNumber != 1){
            if (startNumber%2 == 0)
                startNumber /= 2;
            else {
                startNumber *= 3;
                startNumber++;
            }
            termsCount++;
        }
        return termsCount;
    }

    public Problem_014() {
        int maxTerms = 0;
        int startingNumber = 0;
        for (int i=1;i<1_000_000;++i){
            if (maxTerms < getTermsCount(i)){
                startingNumber = i;
                maxTerms = getTermsCount(i);
            }
        }
        System.out.println(startingNumber);
    }
}
