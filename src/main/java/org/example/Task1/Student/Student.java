package org.example.Task1.Student;

public class Student implements Printable {
    private String name;
    private int bookOfTestId;
    private int avgMark;

    public void setStudentInfo(String name, int bookofTestId, int avgMark){
        this.name = name;
        this.bookOfTestId = bookofTestId;
        this.avgMark = avgMark;
    }
    public String getName(){
        return this.name;
    }
    public int getBookOfTestId(){
        return this.bookOfTestId;
    }
    public int getAvgMark(){
        return this.avgMark;
    }

    @Override
    public void print(){
        System.out.println("Имя студена: " + name + ", " + "ID зачетной кнжики: " + bookOfTestId + ", " + "Средний бал: " + avgMark);
    }

}


