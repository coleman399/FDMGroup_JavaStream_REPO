package com.fdmgroup;

import java.util.ArrayList;
import java.util.Map;

public class Catalogue implements ICatalogue {
    private ReadItemCommand readItemCommand;
    private WriteItemCommand writeItemCommand;

    public Catalogue(ReadItemCommand readItemCommand) {
        this.readItemCommand = readItemCommand;
    }

    public Catalogue(WriteItemCommand writeItemCommand) {
        this.writeItemCommand = writeItemCommand;
    }

    public ArrayList<Book> getBook(String isbn) {
        ArrayList<Book> result = new ArrayList<Book>(); 
        for (Map.Entry<String, Book> entry : this.readItemCommand.readAll().entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    @Override
    public void addBook(Book book) {
        writeItemCommand.insertItem(book);
        
    }

    @Override
    public void removeBookByISBN(String isbn) {
        writeItemCommand.deleteItem();     
    }

    @Override
    public Map<String, Book> getAllBooks() {
        return readItemCommand.readAll();
    }  
}
