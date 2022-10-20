package edu.asu.ser515.team33.syllabusgenerator.exporter;

import edu.asu.ser515.team33.syllabusgenerator.syllabus.Syllabus;

import java.io.OutputStream;

public class SyllabusExporterServiceImpl implements SyllabusExporterService {
    @Override
    public OutputStream exportSyllabus(Syllabus syllabus) {
        System.out.println("Exporting syllabus for courseId: " + syllabus.getCourseId());
        System.out.println(syllabus);
        return null;
    }
}
