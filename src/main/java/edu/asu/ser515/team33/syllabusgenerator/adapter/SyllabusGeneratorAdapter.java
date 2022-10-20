package edu.asu.ser515.team33.syllabusgenerator.adapter;

import edu.asu.ser515.team33.syllabusgenerator.controller.SyllabusGeneratorController;

public class SyllabusGeneratorAdapter implements Canvas {
    private SyllabusGeneratorController syllabusGeneratorController;

    public SyllabusGeneratorAdapter(SyllabusGeneratorController syllabusGeneratorController) {
        this.syllabusGeneratorController = syllabusGeneratorController;
    }

    @Override
    public void generateSyllabus(String courseId) {
        System.out.println("Canvas using SyllabusGeneratorAdapter to communicate with SyllabusGeneratorController");
        this.syllabusGeneratorController.initiateSyllabusGenerationWorkflow(courseId);
    }
}
