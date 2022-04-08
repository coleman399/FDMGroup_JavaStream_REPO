package com.bookstoretdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class BasketTest {

    // Test One
    @Test
    public void test_GetBooksInBasket_ReturnsEmptyBookList_IfNoBooksHaveBeenAdded(){
        ArrayList<Book> books = new ArrayList<Book>();
        Basket basket = new Basket(books);
        assertEquals(0, basket.getBooksInBasket().size());
    }

    // Test Two
    @Test
    public void test_GetBooksInBasket_ReturnsArrayOfLengthOne_AfterAddBookMethodIsCalledWithOneBook() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book();
        Basket basket = new Basket(books);
        basket.addBook(book);
        assertEquals(1, basket.getBooksInBasket().size());
    }

    // Test Three
    @Test
    public void test_GetBooksInBasket_ReturnsArrayOfLengthTwo_AfterAddBookMethodIsCalledWithTwoBook() {
        ArrayList<Book> books = new ArrayList<Book>();
        Basket basket = new Basket(books);
        Book book = new Book();
        basket.addBook(book);
        basket.addBook(book);
        assertEquals(2, basket.getBooksInBasket().size());
    }

    // Test Three 1/2
    @Test
    public void test_CalculatePrice_ReturnsSumOfPrice_AfterAddBookMethodIsCalledWithTwoBook() {
        ArrayList<Book> books = new ArrayList<Book>();
        Basket basket = new Basket(books);
        BigDecimal result = new BigDecimal(20.00);
        Book book = new Book();
        basket.addBook(book);
        basket.addBook(book);
        assertEquals(result, basket.calculatePrice());
    }

    // Test Four
    @Test 
    public void testCalculatePrice_OnePercentTax() {
        ArrayList<Book> books = new ArrayList<Book>();
        Basket basket = new Basket(books);
        BigDecimal sum = new BigDecimal(30.00);
        BigDecimal tax = new BigDecimal(0.01);
        BigDecimal result = new BigDecimal(0.00);
        BigDecimal total_Tax = sum.multiply(tax);
        result = sum.subtract(total_Tax);
        Book book = new Book();
        basket.addBook(book);
        basket.addBook(book);
        basket.addBook(book);
        assertEquals(result, basket.calculatePrice());
    }

    // Test Five
    @Test 
    public void testCalculatePrice_TwoPercentTax() {
        ArrayList<Book> books = new ArrayList<Book>();
        Basket basket = new Basket(books);
        BigDecimal sum = new BigDecimal(70.00);
        BigDecimal tax = new BigDecimal(0.02);
        BigDecimal result = new BigDecimal(0.00);
        BigDecimal total_Tax = sum.multiply(tax);
        result = sum.subtract(total_Tax);
        Book book = new Book();
        basket.addBook(book);
        basket.addBook(book);
        basket.addBook(book);
        basket.addBook(book);
        basket.addBook(book);
        basket.addBook(book);
        basket.addBook(book);
        assertEquals(result, basket.calculatePrice());
    }

    // Test Six
    @Test 
    public void testCalculatePrice_ThirteenPercentTax() {
        ArrayList<Book> books = new ArrayList<Book>();
        Basket basket = new Basket(books);
        BigDecimal sum = new BigDecimal(100.00);
        BigDecimal tax = new BigDecimal(0.13);
        BigDecimal result = new BigDecimal(0.00);
        BigDecimal total_Tax = sum.multiply(tax);
        result = sum.subtract(total_Tax);
        Book book = new Book();
        basket.addBook(book);
        basket.addBook(book);
        basket.addBook(book);
        basket.addBook(book);
        basket.addBook(book);
        basket.addBook(book);
        basket.addBook(book);
        basket.addBook(book);
        basket.addBook(book);
        basket.addBook(book);
        assertEquals(result, basket.calculatePrice());
    } 
}
