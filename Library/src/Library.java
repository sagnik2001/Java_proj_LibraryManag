// To create the menu of the problem

// Importing classes

import java.util.Scanner;

import book.book;
import books.books;
import student.student;
import students.students;

public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Displaying the Menu
        System.out.println(
                "********************Welcome to UEM Library!********************");
        System.out.println(
                "                  Select From The Following Options:               ");
        System.out.println(
                "**********************************************************************");

        // creating object of books class

        books ob = new books();

        // creating object of students class

        students obstudent = new students();

        int choice, searchchoice;
        char option;

        do {
            ob.displayMenu();
            choice = sc.nextInt();

            // Switch Case

            switch (choice) {
                // Cases
                case 1:
                    book b = new book();
                    ob.addBook(b);
                    break;

                case 2:
                    System.out.println("-----------X----------");
                    System.out.println("Press 1 to search book by serial number");
                    System.out.println("Press 2 to search book by book name");
                    searchchoice = sc.nextInt();

                    switch (searchchoice) {
                        case 1:
                            ob.searchByserialNum();
                            break;
                        case 2:
                            ob.searchBybookName();
                            break;
                        default:
                            System.out.println("Enter Number 1 or 2");
                    }
                    break;

                case 3:
                    ob.showAllBooks();
                    break;

                case 4:
                    ob.upgradeBookQty();
                    break;

                case 5:
                    student s = new student();
                    obstudent.addStudent(s);
                    break;
                case 6:
                    obstudent.showAllStudents();
                    break;
                case 7:
                    obstudent.IssueBook();
                    break;

                case 8:
                    obstudent.checkStudent();
                    break;
                default:
                    System.out.println("Enter in the range of 1-8");
            }

            System.out.println("Do you want to select next option : Y/N");
            option = sc.next().charAt(0);
        } while (option == 'y' || option == 'Y');

        sc.close();
    }
}