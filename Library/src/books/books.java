package books;

import java.util.Scanner;

import book.book;

// Java class File to add issue return search books and update quantity

public class books {

    // method display Menu

    book Books[] = new book[100];
    public static int count;

    Scanner sc = new Scanner(System.in);

    public void displayMenu() {
        // Displaying Menu

        System.out.println("----------------------------------------------------");
        System.out.println("Press 1 to Add new Book");
        System.out.println("Press 2 to Search a Book");
        System.out.println("Press 3 to Show All Books");
        System.out.println("Press 4 to Upgrade The Quantity Of Books");
        System.out.println("Press 5 to Register Students");
        System.out.println("Press 6 to Show All Students");
        System.out.println("Press 7 to Issue A Book");
        System.out.println("Press 8 to Return A Book");
        System.out.println("----------------------------------------------------");
    }

    public int compareBooks(book a, book b) {
        // compare the name of book
        if (a.bookName.equalsIgnoreCase(b.bookName)) {
            System.out.println("Similar book exists");
            return 0;
        }
        // compare the slno of book
        if (a.slNo == b.slNo) {
            System.out.println("Book of same serial Number exists");
            return 0;
        }
        return 1;
    }

    // method to add new Book

    public void addBook(book b) {
        // Compare if the book already exists in library
        for (int i = 0; i < count; i++) {
            if (this.compareBooks(b, this.Books[i]) == 0) {
                return; // if its already present
            }
        }

        if (count > 100) {
            System.out.println("The Library is full");
        } else {
            Books[count] = b;
            count++;
        }

    }

    // Method to upgrade the quantity of Book

    public void upgradeBookQty() {
        System.out.println("\t\t Upgrade Quantity Of Book \n");
        System.out.println("Enter Serial Number of Book");
        int slNo = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (Books[i].slNo == slNo) {
                System.out.println("Enter Number of Books to be added");
                int bookqty = sc.nextInt();
                Books[i].bookQty += bookqty;
                Books[i].bookQtyCopy += bookqty;
                return;
            }
        }
        System.out.println("The Book is not added in the library");
    }

    // Method to search by serial Number

    public void searchByserialNum() {
        System.out.println("Enter serial number of the book to be searched:");
        int slNo = sc.nextInt();

        int flag = 0;

        for (int i = 0; i < count; i++) {
            if (slNo == Books[i].slNo) {
                System.out.println(Books[i].slNo + "\t\t" + Books[i].bookName + "\t\t" + Books[i].authorName + "\t\t"
                        + Books[i].bookQtyCopy);
                flag++;
            }
        }

        if (flag == 0) {
            System.out.println("The Book with the serial number doesnot exist.");
        }

    }

    // Method to search by serial Number

    public void searchBybookName() {
        System.out.println("Enter serial number of the book to be searched:");
        String slNo = sc.nextLine();

        int flag = 0;

        for (int i = 0; i < count; i++) {
            if (slNo.equalsIgnoreCase(Books[i].bookName)) {
                System.out.println(Books[i].slNo + "\t\t" + Books[i].bookName + "\t\t" + Books[i].authorName + "\t\t"
                        + Books[i].bookQtyCopy);
                flag++;
            }
        }

        if (flag == 0) {
            System.out.println("The Book with the book name doesnot exist.");
        }

    }

    // Method to show All books in the library

    public void showAllBooks() {
        System.out.println("SerialNumber\t\tBookName\t\tAuthorName\t\tAvailableQuantity\t\tTotalQuantity");

        for (int i = 0; i < count; i++) {
            System.out.println(Books[i].slNo + "\t\t" + Books[i].bookName + "\t\t" + Books[i].authorName + "\t\t"
                    + Books[i].bookQtyCopy + "\t\t" + Books[i].bookQty);
        }

    }

    // Method to check if the book is available

    public int isAvailable(int sNo)
    {
 
        for (int i = 0; i < count; i++) {
            if (sNo == Books[i].slNo) {
                if (Books[i].bookQtyCopy > 0) {
 
                    System.out.println(
                        "Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }
 
        System.out.println("No Book of Serial Number "
                           + " Available in Library.");
        return -1;
    }
     
    // Method to issue a new book

    public book issueBook()
    {
        System.out.println("Enter serial Number of Book to issue");
        int slNo = sc.nextInt();

        int bookInd = isAvailable(slNo);


        if (bookInd != -1) {
            Books[bookInd].bookQtyCopy--;
            return Books[bookInd];
        }
        return null;
    }

    // Method to return a book
    public void checkInBook(book b)
    {
        for (int i = 0; i < count; i++) {
            if (b.equals(Books[i])) {
                Books[i].bookQtyCopy++;
                return;
            }
        }
    }
}
