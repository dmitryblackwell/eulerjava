package com.blackwell.level_01;

public class Problem_017 {
    private static final String[] basicWords = {"one","two","three","four","five","six","seven","eight","nine","ten",
            "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen","Twenty",
            "Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety","Hundred"};

    private String getNumWords(int num){
        String numWord="";

        int hundreds = (int) Math.floor(num/100);
        if ( hundreds > 0)
            numWord += basicWords[hundreds] + basicWords[27]+ "and";

        int coins= num%100;
        if (coins > 0 && coins < 21)
            numWord += basicWords[coins-1];
        else if(coins>20 && coins<100) {
            int dozen=(int) Math.floor(coins/10) - 3 + 20;
            int ones = coins%10 -1;
            numWord += basicWords[dozen] + basicWords[ones];
        }
        return numWord;
    }
    
    public Problem_017() {
        System.out.println(getNumWords(0));
        System.out.println(getNumWords(1));
        System.out.println(getNumWords(5));
        System.out.println(getNumWords(11));
        System.out.println(getNumWords(16));
        System.out.println(getNumWords(20));
        System.out.println(getNumWords(25));
        System.out.println(getNumWords(30)); //error here
        System.out.println(getNumWords(50));
        System.out.println(getNumWords(100));
        System.out.println(getNumWords(101));
        System.out.println(getNumWords(105));
        System.out.println(getNumWords(110));
        System.out.println(getNumWords(120));
        System.out.println(getNumWords(130));
        System.out.println(getNumWords(134));
        System.out.println(getNumWords(150));
        System.out.println(getNumWords(456));
        System.out.println(getNumWords(500));
        System.out.println(getNumWords(999));
    }
}