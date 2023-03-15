package com.company.bookstore.controller;

import com.company.bookstore.models.Author;
import com.company.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    @Autowired
    AuthorRepository repo;

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return repo.findAll();
    }

    @GetMapping("/authors/{author_id}")
    public Author getAuthorById(@PathVariable int author_id) {

        Optional<Author> returnVal = repo.findById(author_id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author Author) {
        return repo.save(Author);
    }

    @PutMapping("/authors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(@RequestBody Author Author) {
        repo.save(Author);
    }

    @DeleteMapping("/authors/{author_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int author_id) {
        repo.deleteById(author_id);
    }
}
