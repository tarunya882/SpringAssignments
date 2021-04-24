package com.example.demo.controller;


import com.example.demo.model.Book;
import com.example.demo.service.BookServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookServiceImplementation bookServiceImplementation;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookServiceImplementation.getAllBooks();
    }

    @GetMapping("/book")
    ResponseEntity<Book> getBookById(@RequestParam("id") Long bookId) {
        Book book= bookServiceImplementation.getBook(bookId);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping("/book")
    ResponseEntity<?> addBook(@RequestBody Book book) {
        bookServiceImplementation.saveBook(book);
        return ResponseEntity.ok().body("A new book is added");
    }

    @PutMapping("/book")
    ResponseEntity<Book> updateBook(@RequestParam("id") Long bookId,
                           @Valid @RequestBody Book bookDetails) {
        Book book=bookServiceImplementation.getBook(bookId);
        book.setTitle(bookDetails.getTitle());
        bookServiceImplementation.saveBook(bookDetails);
        return ResponseEntity.ok().body(bookDetails);
    }

    @DeleteMapping("/book")
    ResponseEntity<?> deleteBook(@RequestParam("id") Long bookId) {
        Book book = bookServiceImplementation.getBook(bookId);

        bookServiceImplementation.deleteBook(book);
        return ResponseEntity.ok().body("Book with ID:"+bookId+" is deleted");
    }
}
