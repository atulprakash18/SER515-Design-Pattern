package edu.asu.ser515.team33.syllabusgenerator.syllabus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Syllabus {
    private String courseId;
    private String courseTitle;
    private String version;
    private LocalDateTime createdAt;
    private final List<Section> sections;

    public Syllabus() {
        this.sections = new ArrayList<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void addSection(Section section) {
        this.sections.add(section);
    }

    @Override
    public String toString() {
        return "Syllabus{" +
                "sections=" + sections +
                '}';
    }
}
