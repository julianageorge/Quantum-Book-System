package QuantumBookstore;

import java.util.Calendar;

public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, String author, int year, double price, int stock) {
        super(isbn, title, author, year, price);
        this.stock = stock;
    }

    @Override
    public double buy(int quantity, String email, String address) throws Exception {
        if (quantity > stock) {
            throw new Exception("Quantum book store Error: Not enough stock");
        }
        stock -= quantity;
        double total = quantity * price;
        System.out.println("Quantum book store: Paper book '" + title + "' sold. Total = $" + total);
        ShippingService.send(address);
        return total;
    }

    @Override
    public boolean isOutdated(int maxAge) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return (currentYear - year) > maxAge;
    }
}