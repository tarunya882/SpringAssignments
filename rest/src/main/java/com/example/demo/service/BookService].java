package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;
interface BookService {

    List<Book> getAllBooks();
    Book getBook(Long bookId);
    void saveBook(Book book);
    void deleteBook(Book book);

}
