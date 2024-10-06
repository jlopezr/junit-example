package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        // Add initial books tothe library for testing
        library.addBook(new Book("1984", "George Orwell", 1949));
        library.addBook(new Book("To Kill aMockingbird", "Harper Lee",
                1960));
        library.addBook(new Book("Brave NewWorld", "Aldous Huxley", 1932)
        );
        library.addBook(new Book("Animal Farm", "George Orwell", 1945));
        library.addBook(new Book("TheCatcher in the Rye", "J.D. Salinger"
                , 1949)); // Newbook added
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Retrieve books by author");
            System.out.println("4. Retrieve books by year");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter book title:");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book year:");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.addBook(new Book(title, author, year));
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter book title to remove:");
                    String removeTitle = scanner.nextLine();

                    if(library.removeBook(removeTitle)) {
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter author name: ");
                    String searchAuthor = scanner.nextLine();
                    ArrayList<Book> booksByAuthor = library.getBooksByAuthor(searchAuthor);
                    System.out.println("Books by " + searchAuthor + ":");
                    for (Book book : booksByAuthor) {
                        System.out.println(book.getTitle() + " (" + book.getYear() + ")");
                    }
                    break;
                case 4:
                    System.out.print("Enter year:");
                    int searchYear = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    ArrayList<Book> booksByYear = library.getBooksByYear(searchYear);
                    System.out.println("Books from the year " + searchYear + ":");
                    for (Book book : booksByYear) {
                        System.out.println(book.getTitle() + " by " + book
                                .getAuthor());
                    }
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}