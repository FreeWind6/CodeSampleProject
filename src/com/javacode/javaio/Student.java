package com.javacode.javaio;

import com.javacode.collections.map.treemap.SubjectGrade;

import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable {

    private String name;
    private float averageGrade;
    private Set<SubjectGrade> grades;

    public Student(String name, float averageGrade, Set<SubjectGrade> grades) {
        this.name = name;
        this.averageGrade = averageGrade;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public float getAverageGrade() {
        return averageGrade;
    }

    public Set<SubjectGrade> getGrades() {
        return grades;
    }


}
