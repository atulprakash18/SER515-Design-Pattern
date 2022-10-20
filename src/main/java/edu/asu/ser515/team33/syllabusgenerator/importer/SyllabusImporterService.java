package edu.asu.ser515.team33.syllabusgenerator.importer;

import edu.asu.ser515.team33.syllabusgenerator.syllabus.Syllabus;

import java.io.InputStream;

public interface SyllabusImporterService {
    Syllabus parseFile(InputStream file);
}
