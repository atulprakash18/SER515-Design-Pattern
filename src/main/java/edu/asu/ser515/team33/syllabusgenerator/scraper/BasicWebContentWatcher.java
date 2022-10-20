package edu.asu.ser515.team33.syllabusgenerator.scraper;

import java.time.LocalDateTime;

public class BasicWebContentWatcher extends WebContentWatcher {
    public BasicWebContentWatcher(WebContent resource) {
        super(resource);
    }

    @Override
    public void checkContentForUpdates() {
        System.out.println("WatcherId: " + Thread.currentThread().getId() +
                "\nWatcher triggered at: " + LocalDateTime.now() +
                "\nWatching web content for changes: " + this.getResource());
    }
}
