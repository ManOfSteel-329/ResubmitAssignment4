package com.coderscampus.Assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class StudentFileServiceApplication {
    public static void main(String[] args) throws FileNotFoundException {
         List<Student> studentList = new ArrayList<>();
         Scanner scanner = new Scanner(new File("student-master-list.csv"));
         try{
            scanner.nextLine();
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] studentData = line.split(",");
                String studentId = studentData[0];
                String studentName = studentData[1];
                String studentCourse = studentData[2];
                int studentGrade = Integer.parseInt(studentData[3]);
                Student student = StudentFileService.CreateStudent(studentId, studentName, studentCourse, studentGrade);
                studentList.add(student);
            }

            Collections.sort(studentList);
             saveToFile(studentList, "COMPSCI", 1);
             saveToFile(studentList, "APMTH", 2);
             saveToFile(studentList, "STAT", 3);
         } catch (Exception e) {
             throw new RuntimeException(e);
         }finally {
             scanner.close();
         }
    }


    private static void saveToFile(List<Student> studentList, String courseName, int courseNum) throws IOException {
        System.out.println("--------------" + courseName);
        System.out.println("Student ID,Student Name,Course,Grade");

        List<Student> group = new ArrayList<>();

        for (Student student : studentList){
            if (student.getStudentCourse().contains(courseName)){
                group.add(student);
                System.out.println(student);
            }
        }

        Collections.sort(group, Comparator.comparingInt(Student::getStudentGrade).reversed());
        FileWriter writer = new FileWriter("course" + courseNum + ".csv");

        writer.write("Student ID,Student Name,Course,Grade\n");
        for (Student student: group) {
            writer.write(student.toString() + "\n");
        }

        writer.close();
    }
}