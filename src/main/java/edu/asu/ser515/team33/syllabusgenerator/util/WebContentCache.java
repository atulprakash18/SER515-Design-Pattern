package edu.asu.ser515.team33.syllabusgenerator.util;

import edu.asu.ser515.team33.syllabusgenerator.scraper.WebContent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebContentCache {
    private static WebContentCache INSTANCE;
    private final Map<String, WebContent> cacheStore;

    private WebContentCache() {
        this.cacheStore = new ConcurrentHashMap<>();
    }

    public static WebContentCache getCache() {
        WebContentCache localRef = INSTANCE;
        if (localRef == null) {
            synchronized (WebContentCache.class) {
                localRef = INSTANCE;
                if (localRef == null) {
                    INSTANCE = localRef = new WebContentCache();
                }
            }
        }
        return localRef;
    }

    public WebContent get(String key) {
        return cacheStore.get(key);
    }

    public void put(String key, WebContent value) {
        cacheStore.put(key, value);
    }
}
