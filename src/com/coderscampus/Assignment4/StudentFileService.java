package com.coderscampus.Assignment4;

public class StudentFileService {
    public static Student CreateStudent(String studentId, String studentName, String studentCourse, Integer studentGrade){
        Student student = new Student(studentId, studentName, studentCourse, studentGrade);
        student.getStudentId();
        student.getStudentName();
        student.getStudentCourse();
        student.getStudentGrade();
        return student;

    }
}
