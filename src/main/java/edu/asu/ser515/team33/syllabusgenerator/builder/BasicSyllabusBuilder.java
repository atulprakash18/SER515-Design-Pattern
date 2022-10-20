package edu.asu.ser515.team33.syllabusgenerator.builder;

import edu.asu.ser515.team33.syllabusgenerator.syllabus.Section;
import edu.asu.ser515.team33.syllabusgenerator.syllabus.Syllabus;
import edu.asu.ser515.team33.syllabusgenerator.util.ConfigUtil;

import java.time.LocalDateTime;
import java.util.List;

public class BasicSyllabusBuilder implements SyllabusBuilder {
    private Syllabus syllabus;
    private String collegeId;
    private String courseId;

    public BasicSyllabusBuilder(String collegeId, String courseId) {
        this.syllabus = new Syllabus();
        this.collegeId = collegeId;
        this.courseId = courseId;
    }

    public void buildCourseId() {
        syllabus.setCourseId(courseId);
    }

    public void buildCourseTitle() {
        syllabus.setCourseTitle("");
    }

    public void buildVersion() {
        syllabus.setVersion("");
    }

    public void buildCreatedAt() {
        syllabus.setCreatedAt(LocalDateTime.now());
    }

    public void buildSections() {
        ConfigUtil configUtil = ConfigUtil.getInstance();
        List<Section> sections = configUtil.getTemplates().get(this.collegeId);
        for (Section section : sections) {
            section.setContent("Dummy Content: " + section.getId());
            syllabus.addSection(section);
        }
    }

    public Syllabus getSyllabus() {
        return this.syllabus;
    }
}
