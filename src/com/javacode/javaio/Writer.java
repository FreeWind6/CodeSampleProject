package com.javacode.javaio;

import com.javacode.collections.map.treemap.AverageStudentGrade;
import com.javacode.collections.map.treemap.SubjectGrade;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            for (Student student : students) {
                out.writeObject(student);
            }
            out.writeObject(new Student("", -1, null));
        } catch (IOException e) {
            System.out.println("File cennot be opened. Program terminates");
            e.printStackTrace();
        }
    }
}
