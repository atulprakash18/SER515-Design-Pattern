package edu.asu.ser515.team33.syllabusgenerator.syllabus;

import java.util.Objects;

public class College {
    private String id;
    private String name;

    public College(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        College college = (College) o;
        return id.equals(college.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
