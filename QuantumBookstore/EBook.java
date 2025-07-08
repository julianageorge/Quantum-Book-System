package QuantumBookstore;

import java.util.Calendar;

public class EBook extends Book{

        private String filetype;

        public EBook(String isbn, String title, String author, int year, double price, String filetype) {
            super(isbn, title, author, year, price);
            this.filetype = filetype;
        }

        @Override
        public double buy(int quantity, String email, String address) throws Exception {
            if (quantity > 1) {
                throw new Exception("Quantum book store Error: EBooks can only be bought only one at a time");
            }
            System.out.println("Quantum book store: EBook '" + title + "' sold. Total = $" + price);
            MailService.send(email);
            return price;
        }

        @Override
        public boolean isOutdated(int maxAge) {
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            return (currentYear - year) > maxAge;
        }
    }

