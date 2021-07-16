package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        int n=3;
        GenerateParenthesis generateParenthesis=new GenerateParenthesis();
        List<String> combinations=generateParenthesis.generateParenthesis(n);
        System.out.println(combinations);
        n=1;
        combinations=generateParenthesis.generateParenthesis(n);
        System.out.println(combinations);
    }
}
