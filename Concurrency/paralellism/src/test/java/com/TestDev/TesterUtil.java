package com.TestDev;

import java.util.HashMap;
import java.util.Map.Entry;

public class TesterUtil {

    public static int missingNumber(int nums[], int k) {
        int count = 0;

        for (int i = 1; i < nums.length; i++) {

            if (!(nums[i] == nums[i - 1] + 1)) {
                int miss = nums[i - 1];
                while (nums[i]-miss >1) {
                    count++;
                    miss++;
                    if (count == k)
                        return miss;

                }

            }

        }
return k+nums.length;
    }

    public static int charMapper(char[] chars) {

        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            int grouplength = 1;
            while (grouplength + i < chars.length && chars[i] == chars[grouplength + i])
                grouplength++;
            chars[res++] = chars[i];

            char groupChar[] = String.valueOf(grouplength).toCharArray();
            if (grouplength > 1)
                for (int j = 0; j < groupChar.length; j++) {
                    chars[res++] = groupChar[j];
                }
            i += grouplength - 1;
        }

        return res;
    }

    public static void main(String[] args) {
        HashMap<Character, Integer> hs = new HashMap<>();
        char[] chars = { 'a', 'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c',
                'c', 'c', 'c', 'c', 'c', 'c' };

       // System.out.println(charMapper(chars));
        
        int nums[]={1,2,3,4,5,6,7,8,9,10};
        int k=1;
        System.out.println(missingNumber(nums, k));
        

       // for (char val : chars)
           // System.out.println(val);
//
    }
}
