package com.company.bookstore.controller;

import com.company.bookstore.models.Book;
import com.company.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookRepository repo;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return repo.findAll();
    }

    @GetMapping("/books/{book_id}")
    public Book getBookById(@PathVariable int book_id) {

        Optional<Book> returnVal = repo.findById(book_id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book Book) {
        return repo.save(Book);
    }

    @PutMapping("/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody Book Book) {
        repo.save(Book);
    }

    @DeleteMapping("/books/{book_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int book_id) {
        repo.deleteById(book_id);
    }

    @GetMapping("/books/author_id/{author_id}")
    public List<Book> getBooksByAuthorId(@PathVariable int author_id) {

        return repo.findByAuthorId(author_id);
    }
}