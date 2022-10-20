package edu.asu.ser515.team33.syllabusgenerator.scraper;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public abstract class WebContentWatcher extends TimerTask {
    private final List<WebContentListener> listeners = new ArrayList<>();
    private final WebContent resource;

    public WebContentWatcher(WebContent resource) {
        this.resource = resource;
    }

    public WebContent getResource() {
        return resource;
    }

    public void addListener(WebContentListener listener) {
        listeners.add(listener);
    }

    public void notifyListeners(WebContent event) {
        listeners.forEach(listener -> listener.onWebContentChange(event));
    }

    @Override
    public void run() {
        this.checkContentForUpdates();
    }

    public abstract void checkContentForUpdates();
}
