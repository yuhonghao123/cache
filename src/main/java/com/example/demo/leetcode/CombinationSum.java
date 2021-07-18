package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        dfs(candidates, target, ans, combine, idx + 1);
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum=new CombinationSum();
        int[] candidates ={2,3,6,7};
        int target = 7;
        List<List<Integer>> ans=combinationSum.combinationSum(candidates,target);
        System.out.println(ans);
        int[] candidates1={2,3,5};
        target=8;
        ans=combinationSum.combinationSum(candidates1,target);
        System.out.println(ans);
    }
}
