package edu.asu.ser515.team33.syllabusgenerator.generator;

import edu.asu.ser515.team33.syllabusgenerator.syllabus.Syllabus;

public interface SyllabusGeneratorService {
    Syllabus generateSyllabus(String courseId);
}
