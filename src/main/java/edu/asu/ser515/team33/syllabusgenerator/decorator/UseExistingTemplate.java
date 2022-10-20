package edu.asu.ser515.team33.syllabusgenerator.decorator;

public class UseExistingTemplate implements CreateSyllabusInterface {

    public UseExistingTemplate() {

    }

    @Override
    public void createSyllabus() {
        this.createSyllabusFromExistingTemplate();
    }

    private void createSyllabusFromExistingTemplate() {

    }

}
