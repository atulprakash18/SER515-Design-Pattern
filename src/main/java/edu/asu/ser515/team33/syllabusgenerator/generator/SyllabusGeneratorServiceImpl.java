package edu.asu.ser515.team33.syllabusgenerator.generator;

import edu.asu.ser515.team33.syllabusgenerator.builder.BasicSyllabusBuilder;
import edu.asu.ser515.team33.syllabusgenerator.builder.SyllabusBuilder;
import edu.asu.ser515.team33.syllabusgenerator.builder.SyllabusDirector;
import edu.asu.ser515.team33.syllabusgenerator.syllabus.Syllabus;

public class SyllabusGeneratorServiceImpl implements SyllabusGeneratorService {
    @Override
    public Syllabus generateSyllabus(String courseId) {
        System.out.println("Generating Syllabus");
        // Fetch collegeId using the courseId
        String collegeId = "IAFSE"; // Using dummy value over here
        SyllabusDirector director = new SyllabusDirector();
        SyllabusBuilder syllabusBuilder = new BasicSyllabusBuilder(collegeId, courseId);
        director.constructSyllabus(syllabusBuilder);

        return syllabusBuilder.getSyllabus();
    }
}
