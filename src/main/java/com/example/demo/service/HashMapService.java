package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

public interface HashMapService<K,V> {
    V get(K key, HashMap<K,V> hashMap);

    void put(K key, V value, HashMap<K,V> hashMap);

    void putAll(Map<? extends K, ? extends V> map, HashMap<K,V> hashMap);

    long size(HashMap<K,V> hashMap);

    void clear(HashMap<K,V> hashMap);

    void putLRUCache(K key, V value, HashMap<K,V> hashMap,int size);
}
