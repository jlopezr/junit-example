package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

public class LibraryTest {

    Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();

        library.addBook(new Book("1984", "George Orwell", 1949));
        library.addBook(new Book("To Kill aMockingbird", "Harper Lee", 1960));
        library.addBook(new Book("Brave NewWorld", "Aldous Huxley", 1932));
        library.addBook(new Book("Animal Farm", "George Orwell", 1945));
        library.addBook(new Book("TheCatcher in the Rye", "J.D. Salinger", 1949));
    }

    @Test
    public void addBook() {
        assertEquals(0, library.getBooksByYear(2024).size());
        Book b = new Book("El centímetre de Déu", "Cesc Llaverias", 2024);
        library.addBook(b);
        assertEquals(1, library.getBooksByYear(2024).size());
        Book b2 = library.getBooksByYear(2024).get(0);
        assertEquals(b, b2);
    }

    @Test
    public void removeBook() {
        assertEquals(2, library.getBooksByYear(1949).size());
        assertTrue(library.removeBook("1984"));
        assertEquals(1, library.getBooksByYear(1949).size());
        assertTrue(library.removeBook("TheCatcher in the Rye"));
        assertEquals(0, library.getBooksByYear(1949).size());
        assertFalse(library.removeBook("Unknown book"));
    }

    @Test
    public void getBooksByAuthor() {
        ArrayList<Book> books = library.getBooksByAuthor("George Orwell");
        assertEquals(2, books.size());
        Book b1 = new Book("1984", "George Orwell", 1949);
        Book b2 = new Book("Animal Farm", "George Orwell", 1945);

        assertThat(books.get(0), samePropertyValuesAs(b1));
        assertThat(books.get(1), samePropertyValuesAs(b2));
    }

    @Test
    public void getBooksByYear() {
        ArrayList<Book> books = library.getBooksByYear(1949);
        assertEquals(2, books.size());
        Book b1 = new Book("1984", "George Orwell", 1949);
        Book b2 = new Book("TheCatcher in the Rye", "J.D. Salinger", 1949);

        assertThat(books.get(0), samePropertyValuesAs(b1));
        assertThat(books.get(1), samePropertyValuesAs(b2));
    }
}