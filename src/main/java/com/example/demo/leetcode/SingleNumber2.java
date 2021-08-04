package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
    给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SingleNumber2 singleNumber2=new SingleNumber2();
        int[] nums={2,2,3,2};
        int result=singleNumber2.singleNumber(nums);
        System.out.println(result);
    }
}
