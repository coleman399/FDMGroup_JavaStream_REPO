package com.fdmgroup;

import java.util.ArrayList;

public interface ReadItemCommand {
    public ArrayList<Book> readAll();
    public Book getItem(String id);
}
