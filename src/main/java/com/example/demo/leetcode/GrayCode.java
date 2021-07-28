package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。

给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。

格雷编码序列必须以 0 开头
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        GrayCode grayCode=new GrayCode();
        int n=2;
        List<Integer> result=grayCode.grayCode(n);
        System.out.println(result);
        n=0;
        result=grayCode.grayCode(n);
        System.out.println(result);
    }
}
