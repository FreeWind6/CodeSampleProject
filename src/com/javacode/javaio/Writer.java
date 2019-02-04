package com.javacode.javaio;

import com.javacode.collections.map.treemap.AverageStudentGrade;
import com.javacode.collections.map.treemap.SubjectGrade;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Writer {

    public void writeWithFormatter() throws FileNotFoundException {
        Formatter formatter = new Formatter("BankAccounts.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter clientID, clientName, client surname, account balance");
        int i = 0;
        while (i < 3) {
            try {
                formatter.format("%d, %s, %s, %.2f%n", scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextFloat());
                i++;
            } catch (InputMismatchException e) {
                System.out.println("Input is incorrect. Please try again");
                scanner.nextLine();
            }
        }
        formatter.close();
    }


    public void writeFile(SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades, String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (AverageStudentGrade gradeKey : grades.keySet()) {
                writer.write("===========================\n");
                writer.write("Student: " + gradeKey.getName() + " Average grade: " + gradeKey.getAverageGrade() + "\n");
                for (SubjectGrade grade : grades.get(gradeKey)) {
                    writer.write("Subject: " + grade.getSubject() + " Grade: " + grade.getGrade() + "\n");
                }
            }
        }
    }

    public void writeObject(List<Student> students, String fileName) {

    }
}
