package student;

import java.util.Scanner;

import book.book;

public class student {
    public String studentName;
    public String enrName;

    public book borrowedBook[] = new book[5];
    public int bookCount = 0;

    Scanner sc = new Scanner(System.in);

    public student() {
        System.out.println("Enter student name");
        this.studentName = sc.nextLine();
        System.out.println("Enter enrollment number of student");
        this.enrName = sc.nextLine();

    }
}
