package com.example.demo.po;

import com.example.demo.test.DelayItem;
import lombok.Data;

import javax.naming.TimeLimitExceededException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


@Data
public class CachePo<K,V> {

    private Logger logger = Logger.getLogger(CachePo.class.getName());
    private DelayQueue<DelayItem<K>> q = new DelayQueue<>();
    /**
     * 多线程安全的Maps
     */
    private ConcurrentMap<K, V> maps = new ConcurrentHashMap<K, V>();
    private long liveTime;
    /**
     * 守护进程
     */
    private Thread daemonThread;

    public CachePo(long liveTime) {
        this.liveTime = liveTime;
        Runnable daemonTask = new Runnable() {
            public void run() {
                daemonCheck();
            }
        };
        daemonThread = new Thread(daemonTask);
        daemonThread.setDaemon(true);
        daemonThread.setName("Cache Daemon");
        daemonThread.start();
    }

    public void put(K key, V value) {
        this.put(key, value, liveTime, TimeUnit.MILLISECONDS);
    }

    public void put(K key, V value, long outtime) {
        this.put(key, value, outtime, TimeUnit.MILLISECONDS);
    }

    public void put(K key, V value, long outtime, TimeUnit timeUnit) {
        if (outtime <= 0) {
            try {
                throw new TimeLimitExceededException("Cache livetime below 0");
            } catch (TimeLimitExceededException e) {
                e.printStackTrace();
            }
        }
        V oldValue = maps.put(key, value);
        if (oldValue != null)
            q.remove(key);
        q.put(new DelayItem<K>(key, outtime, timeUnit));
    }

    public V get(K key) {
        return maps.get(key);
    }

    private void daemonCheck() {
        if (logger.isLoggable(Level.INFO))
            logger.info("cache service started.");
        for (;;) {
            try {
                DelayItem<K> delayItem = q.take();
                if (delayItem != null)
                    maps.remove(delayItem.getItem());
            } catch (InterruptedException e) {
                if (logger.isLoggable(Level.SEVERE))
                    logger.log(Level.SEVERE, e.getMessage(), e);
                e.printStackTrace();
                break;
            }
        }
        if (logger.isLoggable(Level.INFO))
            logger.info("cache service stopped.");
    }
}
