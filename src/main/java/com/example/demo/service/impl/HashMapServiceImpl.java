package com.example.demo.service.impl;

import com.example.demo.service.HashMapService;

import java.util.HashMap;
import java.util.Map;

public class HashMapServiceImpl<K,V> implements HashMapService<K,V> {

    @Override
    public V get(K key, HashMap<K, V> hashMap) {
        return hashMap.get(key);
    }

    @Override
    public void put(K key, V value, HashMap<K, V> hashMap) {
        hashMap.put(key, value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map, HashMap<K, V> hashMap) {
        hashMap.putAll(map);
    }

    @Override
    public long size(HashMap<K, V> hashMap) {
        return hashMap.size();
    }

    @Override
    public void clear(HashMap<K, V> hashMap) {
        hashMap.clear();
    }

    @Override
    public void putLRUCache(K key, V value, HashMap<K, V> hashMap, int size) {
        Map.Entry<K, V> tail = hashMap.entrySet().iterator().next();
        if (hashMap.size()>=size){
            hashMap.remove(tail.getKey());
        }
        hashMap.put(key,value);
    }
}
