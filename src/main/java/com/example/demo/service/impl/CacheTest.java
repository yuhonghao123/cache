package com.example.demo.service.impl;


import com.example.demo.po.CachePo;

public class CacheTest {
    public static void main(String[] args) throws InterruptedException {
        CachePo<String, Integer> cache = new CachePo<>(4000);
        cache.put("AAAA", 3);
        cache.put("BBBB", 4, 4000);
        System.out.println(cache.get("AAAA"));

        Thread.sleep(3000);
        System.out.println(cache.get("BBBB"));

        Thread.sleep(1200);
        System.out.println(cache.get("AAAA"));
        System.out.println(cache.get("BBBB"));
    }
}
