package edu.asu.ser515.team33.syllabusgenerator.builder;

public class SyllabusDirector {

    public void constructSyllabus(SyllabusBuilder syllabusBuilder) {
        syllabusBuilder.buildCourseId();
        syllabusBuilder.buildCourseTitle();
        syllabusBuilder.buildCreatedAt();
        syllabusBuilder.buildVersion();
        syllabusBuilder.buildSections();
    }
}
