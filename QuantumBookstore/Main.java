package QuantumBookstore;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        QuantumBookstore store = new QuantumBookstore();


        Book book1 = new PaperBook("1", "Java basic book", "Juliana", 2010, 30.0, 10);
        Book book2 = new EBook("2", " Python", "User", 2020, 15.0, "PDF");
        Book book3 = new ShowcaseBook("3", "test book", "user2", 1900);

        store.addBook(book1);
        store.addBook(book2);
        store.addBook(book3);


        try {
            store.buyBook("1", 2, "user@gmail.com", "28 Street");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            store.buyBook("2", 1, "user@gmail.com", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            store.buyBook("3", 1, "user@gmail.com", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Book> removedBooks = store.removeOutdatedBooks(8);
        System.out.println("Quantum book store: Total outdated books removed: " + removedBooks.size());
    }
}