package book;

import java.util.Scanner;;

public class book {
    // Class data members
    public int slNo;
    public int bookQty;
    public int bookQtyCopy;
    public String bookName;
    public String authorName;

    Scanner sc = new Scanner(System.in);

    // Constructor book
    // To add the book details

    public book() {
        System.out.println("Enter Serial Number of book");
        this.slNo = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter BookName");
        this.bookName = sc.nextLine();
        System.out.println("Enter Author Name");
        this.authorName = sc.nextLine();
        System.out.println("Enter Quantity of Books");
        this.bookQty = sc.nextInt();
        bookQtyCopy = this.bookQty;
    }
}
