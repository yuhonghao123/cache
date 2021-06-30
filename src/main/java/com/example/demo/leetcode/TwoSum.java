package com.example.demo.leetcode;

/*
    给定一个整数数组 num 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案

 */
public class TwoSum {
    public int[] twoSum(int[] num,int target){
        int[] result=new int[num.length];
        for (int i = 0; i < num.length; i++) {
            int x=num[i];
            for (int j = i+1; j < num.length; j++) {
                int y=num[j];
                if (x+y==target){
                    result[0]=x;
                    result[1]=y;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum=new TwoSum();
        int[] num ={2,7,11,15};
        int target = 9;
        int[] result=twoSum.twoSum(num,target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
