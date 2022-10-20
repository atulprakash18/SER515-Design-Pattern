package edu.asu.ser515.team33.syllabusgenerator.importer;

import edu.asu.ser515.team33.syllabusgenerator.syllabus.Syllabus;

import java.io.InputStream;

public class SyllabusImporterServiceImpl implements SyllabusImporterService {
    @Override
    public Syllabus parseFile(InputStream file) {
        System.out.println("Importing existing syllabus");
        return null;
    }
}
