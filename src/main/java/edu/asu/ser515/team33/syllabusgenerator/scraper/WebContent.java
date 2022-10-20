package edu.asu.ser515.team33.syllabusgenerator.scraper;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Objects;

public class WebContent {
    private final URL url;
    private final String domSelector;
    private LocalDateTime lastCheckTimestamp;
    private String lastContentHash;
    private String content;

    public WebContent(URL url, String domSelector, LocalDateTime lastCheckTimestamp, String lastContentHash, String content) {
        this.url = url;
        this.domSelector = domSelector;
        this.lastCheckTimestamp = lastCheckTimestamp;
        this.lastContentHash = lastContentHash;
        this.content = content;
    }

    public LocalDateTime getLastCheckTimestamp() {
        return lastCheckTimestamp;
    }

    public void setLastCheckTimestamp(LocalDateTime lastCheckTimestamp) {
        this.lastCheckTimestamp = lastCheckTimestamp;
    }

    public String getLastContentHash() {
        return lastContentHash;
    }

    public void setLastContentHash(String lastContentHash) {
        this.lastContentHash = lastContentHash;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebContent that = (WebContent) o;
        return url.equals(that.url) && domSelector.equals(that.domSelector) && Objects.equals(lastCheckTimestamp, that.lastCheckTimestamp) && Objects.equals(lastContentHash, that.lastContentHash) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, domSelector, lastCheckTimestamp, lastContentHash, content);
    }

    @Override
    public String toString() {
        return "WebContent{" +
                "url=" + url +
                ", domSelector='" + domSelector + '\'' +
                ", lastCheckTimestamp=" + lastCheckTimestamp +
                ", lastContentHash='" + lastContentHash + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
