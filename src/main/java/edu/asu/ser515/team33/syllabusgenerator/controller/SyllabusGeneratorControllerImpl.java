package edu.asu.ser515.team33.syllabusgenerator.controller;

import edu.asu.ser515.team33.syllabusgenerator.exporter.SyllabusExporterService;
import edu.asu.ser515.team33.syllabusgenerator.generator.SyllabusGeneratorService;
import edu.asu.ser515.team33.syllabusgenerator.importer.SyllabusImporterService;
import edu.asu.ser515.team33.syllabusgenerator.syllabus.Syllabus;

import java.io.InputStream;
import java.io.OutputStream;

public class SyllabusGeneratorControllerImpl implements SyllabusGeneratorController {
    private final SyllabusImporterService importerService;
    private final SyllabusGeneratorService generatorService;
    private final SyllabusExporterService exporterService;

    public SyllabusGeneratorControllerImpl(SyllabusImporterService importerService, SyllabusGeneratorService generatorService, SyllabusExporterService exporterService) {
        this.importerService = importerService;
        this.generatorService = generatorService;
        this.exporterService = exporterService;
    }

    @Override
    public void initiateSyllabusGenerationWorkflow(String courseId) {
        System.out.println("Initiated syllabus generation workflow in Syllabus Generator");

        this.importSyllabus(null);
        Syllabus syllabus = this.generateSyllabus(courseId);
        this.exportSyllabus(syllabus);

    }

    void importSyllabus(InputStream uploadedExistingSyllabus) {
        this.importerService.parseFile(null);
    }

    Syllabus generateSyllabus(String courseId) {
        return this.generatorService.generateSyllabus(courseId);
    }

    OutputStream exportSyllabus(Syllabus generatedSyllabus) {
        this.exporterService.exportSyllabus(generatedSyllabus);
        return null;
    }
}
