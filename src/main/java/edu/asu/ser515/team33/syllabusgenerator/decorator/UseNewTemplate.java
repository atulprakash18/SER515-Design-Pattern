package edu.asu.ser515.team33.syllabusgenerator.decorator;

public class UseNewTemplate implements CreateSyllabusInterface {

    public UseNewTemplate() {

    }

    @Override
    public void createSyllabus() {
        this.createSyllabusFromNewTemplate();
    }

	private void createSyllabusFromNewTemplate() {

	}
}
