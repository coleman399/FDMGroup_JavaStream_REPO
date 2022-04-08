package com.fdmgroup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class CatalogueTest {
    
    // Test One
    @Test
    public void getAllBooks_ReturnMap_RetrieveFromReadItemCommand_ReadAll() {
        ReadItemCommand readItemCommand = mock(ReadItemCommand.class);
        Catalogue catalogue = new Catalogue(readItemCommand);
        Map<String, Book> result = new HashMap<String, Book>();
        when(readItemCommand.readAll()).thenReturn(result);
        assertEquals(result, catalogue.getAllBooks());
    }

    // Test Two
    @Test
    public void removeBookByISBN_RemoveBookUsingWriteItemCommand_DeleteItem() {
        WriteItemCommand writeItemCommand = mock(WriteItemCommand.class);
        Catalogue catalogue = new Catalogue(writeItemCommand);
        catalogue.removeBookByISBN("12345");
        verify(writeItemCommand, times(1)).deleteItem();
    }

    // Test Three
    @Test
    public void addBook_AddBookUsingWriteItemCommand_InsertItem() {
        WriteItemCommand writeItemCommand = mock(WriteItemCommand.class);
        Catalogue catalogue = new Catalogue(writeItemCommand);
        Book book = mock(Book.class);
        catalogue.addBook(book);
        verify(writeItemCommand, times(1)).insertItem(book);
    }

    // Test Four
    @Test
    public void getBook_ReturnArrayListUsingReadItemCommand_ReadAll() {
        ReadItemCommand readItemCommand = mock(ReadItemCommand.class);
        Catalogue catalogue = new Catalogue(readItemCommand);
        HashMap<String, Book> hashMap = new HashMap<String, Book>();
        Book book = mock(Book.class);
        hashMap.put("12345", book);
        when(readItemCommand.readAll()).thenReturn(hashMap);
        catalogue.getBook("12345");
        assertEquals(1, catalogue.getBook("12345").size());
    }
}
