package com.bookstoretdd;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Basket implements Checkout {
    ArrayList<Book> bookList;

    public Basket(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<Book> getBooksInBasket() {
        return bookList;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public BigDecimal calculatePrice() {
        BigDecimal result = new BigDecimal(0.0);
        if (bookList.size() <= 2 && bookList.size() > 0) {
            for (Book book : bookList) {
                result = result.add(book.getPrice());
            }
            return result;
        } else if (bookList.size() >= 3 && bookList.size() < 7) {
            BigDecimal tax = new BigDecimal(0.01);
            for (Book book : bookList) {
                result = result.add(book.getPrice());
            }
            return result.subtract(result.multiply(tax));
        } else if (bookList.size() >= 7 && bookList.size() < 10) {
            BigDecimal tax = new BigDecimal(0.02);
            for (Book book : bookList) {
                result = result.add(book.getPrice());
            }
            return result.subtract(result.multiply(tax));
        } else {
            BigDecimal tax = new BigDecimal(0.13);
            for (Book book : bookList) {
                result = result.add(book.getPrice());
            }
            return result.subtract(result.multiply(tax));
        }
    }
}
