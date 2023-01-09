package org.example;

public class Student {
//    public Student(int studentID, String studentName, String studentAddress) {
//        super();
//        this.studentID = studentID;
//        this.studentName = studentName;
//        this.studentAddress = studentAddress;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                '}';
    }

    private int studentID;
    private String studentName;
    private String studentAddress;

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public void init() {
        System.out.println("inside init");
    }

    public void destroy() {
        System.out.println("inside destroy");
    }

//    public int getStudentID() {
//        return studentID;
//    }
//
//    public String getStudentName() {
//        return studentName;
//    }
//
//    public String getStudentAddress() {
//        return studentAddress;
//    }
}

