package com.example.demo.service;

import com.example.demo.po.ImmutableMap;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

public interface Cache<K,V> {
    V get(K key, Callable<? extends V> valueLoader) throws ExecutionException;

    ImmutableMap<K, V> getAllPresent(Iterable<?> keys);

    void put(K key, V value);

    void putAll(Map<? extends K, ? extends V> m);

    void invalidate(Object key);

    void invalidateAll(Iterable<?> keys);

    void invalidateAll();

    long size();

//    CacheStats stats();

    ConcurrentMap<K, V> asMap();

    void cleanUp();

}
