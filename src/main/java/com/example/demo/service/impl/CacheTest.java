package com.example.demo.service.impl;


import com.example.demo.po.CachePo;

public class CacheTest {
    public static void main(String[] args) throws InterruptedException {
        CachePo<String, Integer> cache = new CachePo<>(4000);
        for (int i = 0; i < 100000; i++) {
            cache.put("A"+i, i);
            cache.put("B"+i, i,4000);
        }
//        cache.put("AAAA", 3);
//        cache.put("BBBB", 4, 4000);
        System.out.println(cache.get("A1"));
        System.out.println(cache.get("A99999"));

        Thread.sleep(3000);
        System.out.println(cache.get("B99"));

        for (int i = 0; i < 1000000; i++) {
            cache.put("A"+i, i);
            cache.put("B"+i, i,4000);
        }
        System.out.println(cache.get("A999999"));

//        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//
//        HttpServletRequest httpServletRequest=attributes.getRequest();
//
//        String requestPath =httpServletRequest.getRequestURI();
//
//        String cacheKey= requestPath.substring(requestPath.lastIndexOf("/") + 1, requestPath.length());//设置过期时间为1秒
//
//        long qps = cache.put(cacheKey, 1).get("A1");

    }
}
