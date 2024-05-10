package com.coderscampus.Assignment4;

public class Student implements  Comparable<Student>{
    private String studentId;
    private String studentName;
    private String studentCourse;
    private Integer studentGrade;

    Student(String studentId, String studentName, String studentCourse, Integer studentGrade){
        this.studentId=studentId;
        this.studentName=studentName;
        this.studentCourse=studentCourse;
        this.studentGrade=studentGrade;

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public Integer getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(Integer studentGrade) {
        this.studentGrade = studentGrade;
    }

    @Override
    public String toString() {
        // 89,Alison Murray,APMTH 134,93
        return
                 studentId+"," +
                 studentName +"," +
                 studentCourse +","+
                 studentGrade ;
    }

    @Override
    public int compareTo(Student that) {
        if (this.getStudentGrade() > that.getStudentGrade()){
            return -1;
        }else if (this.getStudentGrade() < that.studentGrade){
            return 1;
        }
        return 0;

    }
}
