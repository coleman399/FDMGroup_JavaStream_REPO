package com.fdmgroup;

import java.util.Map;

public interface ICatalogue {
    public void addBook(Book book);
    public void removeBookByISBN(String isbn);
    public Map<String, Book> getAllBooks();
}
