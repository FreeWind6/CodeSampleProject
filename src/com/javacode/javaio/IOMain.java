package com.javacode.javaio;

import com.javacode.collections.map.treemap.AverageStudentGrade;
import com.javacode.collections.map.treemap.SubjectGrade;
import com.javacode.collections.map.treemap.TreeMapRunner;

import java.io.*;
import java.util.*;

public class IOMain {

    private static final String FILE_NAME = "GradeBook.txt";
    private static final String BINARY_FILE = "Students.bin";
    private static final String BUFFERED_FILE = "Buffered.txt";

    public static void main(String[] args) throws IOException {
        SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapRunner.createGrades();
        Reader reeder = new Reader();
        Writer writer = new Writer();
        writer.writeFile(grades, FILE_NAME);
//        reeder.reedFile(FILE_NAME);
//        writer.writeWithFormatter();
//        processGrades(grades, writer, BINARY_FILE);
//        outputObjects(reeder, BINARY_FILE);

        FileUtils utils = new FileUtils();
//        utils.printIOFileDetails("./");
//        utils.printNioFileDetails(FILE_NAME);
//        reeder.readFileInFull(FILE_NAME);
//        reeder.nioReadFileWithBuffer(FILE_NAME);
//        writer.nioWriteWithBuffer(BUFFERED_FILE);
//        reeder.nioReadWithStream(FILE_NAME);
        writer.nioWriteWithStream(BUFFERED_FILE);
    }

    private static void processGrades(SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades, Writer writer, String fileName) {
        List<Student> students = new ArrayList<>();
        for (AverageStudentGrade gradeKey : grades.keySet()) {
            students.add(new Student(gradeKey.getName(), gradeKey.getAverageGrade(), grades.get(gradeKey)));
        }
        writer.writeObject(students, fileName);
    }

    private static void outputObjects(Reader reeder, String fileName) {
        List<Student> students = reeder.readObject(fileName);
        for (Student student : students) {
            System.out.printf("%s, %.2f, %n", student.getName(), student.getAverageGrade());
            System.out.println(student.getGrades());
        }
    }
}
