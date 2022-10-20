package edu.asu.ser515.team33.syllabusgenerator.decorator;

public class UsePreviousSyllabus implements CreateSyllabusInterface {

	public UsePreviousSyllabus() {

	}

	@Override
	public void createSyllabus() {
		this.createSyllabusFromPreviousSyllabus();
	}

	private void createSyllabusFromPreviousSyllabus() {

	}
}
