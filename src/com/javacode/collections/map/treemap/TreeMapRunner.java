package com.javacode.collections.map.treemap;

import java.util.*;

public class TreeMapRunner {
    public static void main(String[] args) {
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades = createGrades();
        printGrade(grades, false);
        AverageStudentGrade border = grades.ceilingKey(new AverageStudentGrade("", 80));
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> scholarshipStudents = (NavigableMap<AverageStudentGrade, Set<SubjectGrade>>) grades.tailMap(border);
        System.out.println("=============================================");
        System.out.println("Scholarship students");
        printGrade(scholarshipStudents.descendingMap(), false);
        System.out.println("Contender student");
        AverageStudentGrade contender = grades.lowerKey(border);
        System.out.println(contender);
        System.out.println("Highest grede student");
        System.out.println(scholarshipStudents.descendingMap().firstEntry());
    }

    private static void printGrade(Map<AverageStudentGrade, Set<SubjectGrade>> grades, boolean printValue) {
        Set<AverageStudentGrade> averageGrades = grades.keySet();
        for (AverageStudentGrade gr : averageGrades) {
            System.out.println(gr);
            if (printValue) {
                System.out.println(grades.get(gr));
            }
        }
    }

    public static NavigableMap<AverageStudentGrade, Set<SubjectGrade>> createGrades() {
        Set<SubjectGrade> alexGrade = new HashSet<>();
        alexGrade.add(new SubjectGrade("Mathematic", 89));
        alexGrade.add(new SubjectGrade("Phisic", 65));
        alexGrade.add(new SubjectGrade("Liter", 95));

        Set<SubjectGrade> jamesGrade = new HashSet<>();
        jamesGrade.add(new SubjectGrade("Mathematic", 98));
        jamesGrade.add(new SubjectGrade("Phisic", 85));
        jamesGrade.add(new SubjectGrade("Liter", 89));

        Set<SubjectGrade> antonyGrade = new HashSet<>();
        antonyGrade.add(new SubjectGrade("Mathematic", 58));
        antonyGrade.add(new SubjectGrade("Phisic", 22));
        antonyGrade.add(new SubjectGrade("Liter", 11));

        Set<SubjectGrade> victoriaGrade = new HashSet<>();
        victoriaGrade.add(new SubjectGrade("Mathematic", 89));
        victoriaGrade.add(new SubjectGrade("Phisic", 15));
        victoriaGrade.add(new SubjectGrade("Liter", 35));

        Set<SubjectGrade> alinaGrade = new HashSet<>();
        alinaGrade.add(new SubjectGrade("Mathematic", 55));
        alinaGrade.add(new SubjectGrade("Phisic", 17));
        alinaGrade.add(new SubjectGrade("Liter", 56));

        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> map = new TreeMap<>();
        map.put(new AverageStudentGrade("Alex", calcAverage(alexGrade)), alexGrade);
        map.put(new AverageStudentGrade("James", calcAverage(jamesGrade)), jamesGrade);
        map.put(new AverageStudentGrade("Antony", calcAverage(antonyGrade)), antonyGrade);
        map.put(new AverageStudentGrade("Victoria", calcAverage(victoriaGrade)), victoriaGrade);
        map.put(new AverageStudentGrade("Alina", calcAverage(alinaGrade)), alinaGrade);

        return map;
    }

    private static float calcAverage(Set<SubjectGrade> grades) {
        float sum = 0f;
        for (SubjectGrade sg : grades) {
            sum += sg.getGrade();
        }
        return sum / grades.size();
    }
}
