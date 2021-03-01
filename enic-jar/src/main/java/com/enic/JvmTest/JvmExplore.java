package com.enic.JvmTest;

import java.util.Arrays;
import java.util.HashMap;

public class JvmExplore {


    public static void main(String[] args) {
        method1();
    }

    public static int method1() {
        int a = 1;
        int b = 2;
        int c = a + b;
        System.out.println(Arrays.toString(twoSum1(new int[]{2, 7, 11, 15}, 13)));
        return c;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] index = {1, 2};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (j > i) {
                    int value = nums[i] + nums[j];
                    if (value == target) {
                        index[0] = i;
                        index[1] = j;
                        return index;
                    }
                }
            }
        }
        return index;
    }
    public static int[] twoSum1(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return indexs;
    }
}
