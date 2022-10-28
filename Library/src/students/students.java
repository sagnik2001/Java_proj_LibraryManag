package students;

// import  student.student;
import java.util.Scanner;

import book.book;
import books.books;
import student.student;

public class students {
    Scanner sc = new Scanner(System.in);
    // student AllStudent[] = new student[50];
    student allStudent[] = new student[50];

    public static int count = 0;

    // Method to add student

    public void addStudent(student A) {
        for (int i = 0; i < count; i++) {
            if (allStudent[i].enrName.equalsIgnoreCase(A.enrName)) {
                System.out.println("Student Of Enrollment Number" + A.enrName + "doesnt exist");
                return;
            }
        }
        if (count > 50) {
            System.out.println("Students Capacity is Full");
        } else {
            allStudent[count] = A;
            count++;
        }
    }

    // Method to show All students

    public void showAllStudents() {
        System.out.println("StudentName\t\tEnrollmentNumber");

        for (int i = 0; i < count; i++) {
            System.out.println(allStudent[i].studentName + "/t/t" + allStudent[i].enrName);
        }
    }

    // Method to check the student is present or not

    public int checkStudent() {
        System.out.println("Enter enrollment number of student:");
        String enrme = sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (allStudent[i].enrName.equalsIgnoreCase(enrme))
                return i;
        }

        System.out.println("The student is not registered /t/t Get registered first");

        return -1;
    }

    // Method to issue a book

    public void IssueBook() {
        int studentInd = this.checkStudent();

        if (studentInd == -1)
            return;

        System.out.println("Displaying Lists Of Books");
        books obBooks = new books();
        obBooks.showAllBooks();

        book b = obBooks.issueBook();

        if (b != null) {

            if (allStudent[studentInd].bookCount <= 5) {

                System.out.println("adding book");
                allStudent[studentInd].borrowedBook[allStudent[studentInd].bookCount] = b;
                allStudent[studentInd].bookCount++;

                return;
            } else {

                System.out.println(
                        "Student Can not Borrow more than 5 Books.");
                return;
            }
        }
        System.out.println("Book is not Available.");

    }

    // Method to return a book
    public void checkInBook(books book) {
        int studentIndex = this.checkStudent();
        if (studentIndex != -1) {

            // Printing credentials corresponding to student
            System.out.println(
                    "S.No\t\t\tBook Name\t\t\tAuthor Name");

            student s = allStudent[studentIndex];

            for (int i = 0; i < s.bookCount; i++) {

                System.out.println(
                        s.borrowedBook[i].slNo + "\t\t\t"
                                + s.borrowedBook[i].bookName + "\t\t\t"
                                + s.borrowedBook[i].authorName);
            }

            // Display message only
            System.out.println(
                    "Enter Serial Number of Book to be Checked In:");

            int sNo = sc.nextInt();

            for (int i = 0; i < s.bookCount; i++) {
                if (sNo == s.borrowedBook[i].slNo) {
                    book.checkInBook(s.borrowedBook[i]);
                    s.borrowedBook[i] = null;

                    return;
                }
            }

            System.out.println("Book of Serial No " + sNo
                    + "not Found");
        }

    }
}