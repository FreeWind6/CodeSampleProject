package com.javacode.javaio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reeder {

    public void reedFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String c;
        while ((c = reader.readLine()) != null) {
            System.out.println(c);
        }
    }

    public List<Student> readObject(String fileName) {
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            boolean keepReeding = true;
            while (keepReeding) {
                Student student = (Student) in.readObject();
                if (!"".equals(student.getName())) {
                    students.add(student);
                } else {
                    keepReeding = false;
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to open file " + fileName + ". Program terminates");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Invalid object type");
            e.printStackTrace();
        }
        return students;
    }
}
