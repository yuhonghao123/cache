package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backtrack(n, output, res, first + 1);
            Collections.swap(output, first, i);
        }
    }

    public static void main(String[] args) {
        Permute permute=new Permute();
        int[] nums={1,2,3};
        List<List<Integer>> res=permute.permute(nums);
        System.out.println(res);
        int[] nums1={0,1};
        res=permute.permute(nums1);
        System.out.println(res);
        int[] nums2={1};
        res=permute.permute(nums2);
        System.out.println(res);
    }
}
