package edu.asu.ser515.team33.syllabusgenerator.syllabus;

public class Section {
    private String id;
    private int order;
    private String title;
    private String content;

    public Section(String id, int order, String title, String content) {
        this.id = id;
        this.order = order;
        this.title = title;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Section{" + "title='" + title + '\'' + ", content='" + content + '\'' + '}';
    }
}
