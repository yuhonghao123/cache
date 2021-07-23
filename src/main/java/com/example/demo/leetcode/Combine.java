package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案
 */
public class Combine {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        dfs(cur + 1, n, k);
    }

    public static void main(String[] args) {
        Combine combine=new Combine();
        int n=4;
        int k=2;
        List<List<Integer>> result=combine.combine(n,k);
        System.out.println(result);
        int n1=1;
        int k1=1;
        result=combine.combine(n1,k1);
        System.out.println(result);
    }
}
