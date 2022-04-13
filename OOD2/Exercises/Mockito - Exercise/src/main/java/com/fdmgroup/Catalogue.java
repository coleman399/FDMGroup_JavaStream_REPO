package com.fdmgroup;

import java.util.ArrayList;

public class Catalogue {
    private ArrayList<Book> bookList;
    private ReadItemCommand read;
    private WriteItemCommand write;


    public Catalogue(ArrayList<Book> bookList, ReadItemCommand read, WriteItemCommand write) {
        this.bookList = bookList;
        this.read = read;
        this.write = write;
    }

    public ArrayList<Book> getAllBooks() {
        return read.readAll();
    }
    
    public void addBook(Book book) {
        write.insertItem(book);
    }

    public void addBooks(ArrayList<Book> books) {
        for (Book book : books) {
            write.insertItem(book);
        }
    }

    public Book getBook(String isbn) {
        return read.getItem(isbn);
    }

    public void deleteBook(Book book) {
        write.deleteItem(book);
    }

    public void deleteAllBooks() {
        bookList = read.readAll();
        for (Book book : bookList) {
            write.deleteItem(book);
        }
    }
}
