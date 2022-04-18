package com.fdmgroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class CatalogueTest {
    private Catalogue catalogue;
    private ReadItemCommand read;
    private WriteItemCommand write;
    private Book mockBook;
    private ArrayList<Book> bookList;

    @BeforeEach
    public void beforeEach() throws Exception {
        this.read = mock(ReadItemCommand.class);
        this.write = mock(WriteItemCommand.class);
        this.mockBook = mock(Book.class);
        this.bookList = new ArrayList<Book>();
        this.catalogue = new Catalogue(bookList, read, write);
    }
    
    // Test One 
    @Test
    public void getAllBooks_ReturnsEmptyBookList_IfNoBooksAreInTheCatalogue(){
        int result = 0;
        ArrayList<Book> returnedList = catalogue.getAllBooks();
        assertEquals(result, returnedList.size());
    }

    // Test Two 
    @Test
    public void getAllBooks_CallsReadAllMethodOfReadItemCommand_WhenCalled(){
        catalogue.getAllBooks();
        verify(read, times(1)).readAll();

    }

    // Test Three
    @Test
    public void getAllBooks_ReturnsListOfBooksItReceivesFromReadAllMethodOfReadItemCommand_WhenCalled(){
        ArrayList<Book> result = bookList;
        ArrayList<Book> returnedList = catalogue.getAllBooks();
        assertEquals(result, returnedList);
    }

    // Test Four
    @Test
    public void addBook_CallsInsertItemMethodOfWriteItemCommand_WhenCalled() {
        catalogue.addBook(mockBook);
        verify(write, times(1)).insertItem(mockBook);
    }

    // Test Five
    @Test
    public void addBooks_AddingMultipleBooksCallsInsertItemMethodOfWriteItemCommand_WhenCalled() {
        catalogue.addBook(mockBook);
        catalogue.addBook(mockBook);
        catalogue.addBook(mockBook);
        verify(write, times(3)).insertItem(mockBook);
    }

    // Test Six
    @Test
    public void getBook_ReturnsBookUsingReadItemCommandGetItemMethod_WhenCalled() {
        Book result = mockBook;
        when(read.getItem("1234")).thenReturn(mockBook);
        Book returnedBook = catalogue.getBook("1234");
        assertEquals(result, returnedBook);
    } 

    // Test Seven
    @Test
    public void deleteBook_DeleteBookUsingDeleteItemMethod_WriteItemCommand() {
        catalogue.deleteBook(mockBook);
        verify(write, times(1)).deleteItem(mockBook);
    }

    // Test Eight
    @Test
    public void deleteAllBooks_CallsReadAllMethodFromReadItemCommandAndDeleteItemFromWriteItemCommandToDeleteAllBooks () {
        bookList.add(mockBook);
        bookList.add(mockBook);
        bookList.add(mockBook);
        when(read.readAll()).thenReturn(bookList);
        catalogue.deleteAllBooks();
        verify(write, times(3)).deleteItem(mockBook);
    }
}
