package com.blackwell.level_01;

public class Problem_004 {
    private boolean isPalindromic(int num){
        String tmp=Integer.toString(num);
        int[] nums = new int[tmp.length()];
        for(int i=0;i<nums.length;++i)
            nums[i]=tmp.charAt(i);
        for(int i=0;i<Math.floor(nums.length/2);++i)
            if (nums[i] != nums[nums.length-1-i])
                return false;
        return true;
    }
    private int findMaxPalindrom(){
        int maxPalindrome = 0;
        for(int i=999;i>99;--i){
            for (int j=999;j>99;--j){
                if (isPalindromic(i*j) && i*j > maxPalindrome)
                    maxPalindrome = i*j;
            }
        }
        return maxPalindrome;
    }
    public Problem_004() {
        System.out.println(findMaxPalindrom());
    }
}
