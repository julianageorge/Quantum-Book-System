package QuantumBookstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuantumBookstore {
    private Map<String, Book> inventory;

    public QuantumBookstore() {
        inventory = new HashMap<>();
    }

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Book '" + book.title + "' added.");
    }

    public List<Book> removeOutdatedBooks(int maxAge) {
        List<String> toRemove = new ArrayList<>();
        for (Map.Entry<String, Book> entry : inventory.entrySet()) {
            if (entry.getValue().isOutdated(maxAge)) {
                toRemove.add(entry.getKey());
            }
        }

        List<Book> removed = new ArrayList<>();
        for (String isbn : toRemove) {
            Book removedBook = inventory.remove(isbn);
            removed.add(removedBook);
            System.out.println("Quantum book store: Removed outdated book ISBN: " + isbn);
        }

        return removed;
    }

    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        if (!inventory.containsKey(isbn)) {
            throw new Exception("Quantum book store Error: Book not found");
        }
        Book book = inventory.get(isbn);
        return book.buy(quantity, email, address);
    }

}
