package com.blackwell.level01;

public class Problem005 {
    public Problem005() {
        int[] divideNum={11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        for (int i=1;true;++i){
            int count=0;
            for(int j=0;j<10;++j)
                if (i % divideNum[j] == 0)
                    count++;
            if (count == 10){
                System.out.println(i);
                break;
            }

        }
    }
}
