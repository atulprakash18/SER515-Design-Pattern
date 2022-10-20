package edu.asu.ser515.team33.syllabusgenerator.builder;

import edu.asu.ser515.team33.syllabusgenerator.syllabus.Syllabus;

public interface SyllabusBuilder {
    void buildCourseId();

    void buildCourseTitle();

    void buildVersion();

    void buildCreatedAt();

    void buildSections();

    Syllabus getSyllabus();
}

