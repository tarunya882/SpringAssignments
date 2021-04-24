package com.example.demo.service;


import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book>getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
    }

    @Override
    public void saveBook(Book book){
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Book book){
        bookRepository.delete(book);
    }
}
