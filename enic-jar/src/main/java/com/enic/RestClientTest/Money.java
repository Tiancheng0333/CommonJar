package com.enic.RestClientTest;

import java.util.Arrays;

public class Money {
    public static void main(String[] args) {
        int[] a={1,2,4,5,7,10};
        //System.out.println(Arrays.toString(shift(a)));
        System.out.println(Arrays.toString(shiftEventNumber(a)));
    }



    public static int[] shift(int[] nums){
        int oldLenth=nums.length;
            if(nums.length<1){
                System.out.println("数组不可为空！");
            }
            int[] newArr={};
           digui(nums,0,newArr);
            int nowLenth=nums.length;
        int value = nowLenth - oldLenth;
        if(value>0){
                for (int i=0;i<oldLenth;i++){
                    if(nums[i]==-1){
                        nums[++i]=-1;
                    }
                }
            }
        return nums;
    }

    public static int[] shiftEventNumber(int[] nums){
        int[] newArr=new int[nums.length];
        int oldLenth=nums.length;
        int index=0;
        for(int i=0;i<=nums.length-1;i++){
            if(nums[i]%2!=0){
                newArr[index]=nums[i];
                index++;
            }
        }
        int nowLenth=0;
        for (int j=0;j<newArr.length;j++){
            if(newArr[j]!=0){
                nowLenth++;
            }
        }
        int value = oldLenth - nowLenth;
        if(value>0){
            for (int i = 0; i < oldLenth; i++) {
                if(i>nowLenth-1){
                    newArr[i]=-1;
                }
            }
        }
        return newArr;
    }

    public static void digui(int[] nums1,int index,int[] newArr){
        if(index>nums1.length-1){
            return;
        }
        int index1=index+1;
        if(index==nums1.length-1&&nums1[index]%2==0){
            nums1[index]=-1;
        }
        if(nums1[index]%2==0&&nums1[index1]%2!=0){
            nums1[index]=nums1[index1];
        }
        newArr[index]=nums1[index];
        index=index+1;
        digui(nums1,index,newArr);
    }

}
