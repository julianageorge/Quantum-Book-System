package QuantumBookstore;

public class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, String author, int year) {
        super(isbn, title, author, year, 0.0);
    }

    @Override
    public double buy(int quantity, String email, String address) throws Exception {
        throw new Exception("Quantum book store Error: Showcase books are not for sale");
    }

    @Override
    public boolean isOutdated(int maxAge) {
        return false;
    }
}

