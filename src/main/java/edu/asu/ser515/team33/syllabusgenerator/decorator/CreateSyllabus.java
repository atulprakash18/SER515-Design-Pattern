package edu.asu.ser515.team33.syllabusgenerator.decorator;

import edu.asu.ser515.team33.syllabusgenerator.syllabus.AdjunctProfessor;
import edu.asu.ser515.team33.syllabusgenerator.syllabus.FullTimeProfessor;
import edu.asu.ser515.team33.syllabusgenerator.syllabus.Professor;

public class CreateSyllabus {

	private Professor professor;
	private CreateSyllabusInterface createSyllabusInterface;

	public CreateSyllabus(Professor professor) {
		this.professor = professor;
	}

	public void createSyllabus() {
		if (professor instanceof FullTimeProfessor) {
			new UsePreviousSyllabus().createSyllabus();
		} else if (professor instanceof AdjunctProfessor) {
			new UseExistingTemplate().createSyllabus();
		} else {
			new UseNewTemplate().createSyllabus();
		}
	}
}
