package edu.asu.ser515.team33.syllabusgenerator.exporter;

import edu.asu.ser515.team33.syllabusgenerator.syllabus.Syllabus;

import java.io.OutputStream;

public interface SyllabusExporterService {
    OutputStream exportSyllabus(Syllabus syllabus);
}
