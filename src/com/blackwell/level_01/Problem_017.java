package com.blackwell.level_01;

public class Problem_017 {
    private static final String[] basicWords = {"one","two","three","four","five","six","seven","eight","nine","ten",
            "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen","Twenty",
            "Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety","Hundred"};

    private String getNumWords(int num){
        String numWord="";
        if (num == 1000)
            return "onethousand";

        int hundreds = (int) Math.floor(num/100);
        if ( hundreds > 0)
            numWord += basicWords[hundreds-1] + basicWords[27];

        int coins= num%100;
        if (hundreds > 0 && coins >0)
            numWord += "and";

        if (coins > 0 && coins < 21)
            numWord += basicWords[coins-1];
        else if(coins>20 && coins<100) {
            int dozen=(int) Math.floor(coins/10) - 3 + 20;
            numWord += basicWords[dozen];
            if (coins%10 != 0)
               numWord += basicWords[coins%10 -1];
        }
        return numWord;
    }
    
    public Problem_017() {
        int sum=0;
        for(int i=1;i<=1_000;++i){
            sum += getNumWords(i).length();
            //System.out.println(i+". "+getNumWords(i) +": " +getNumWords(i).length());
        }
        System.out.println(sum);
    }
}