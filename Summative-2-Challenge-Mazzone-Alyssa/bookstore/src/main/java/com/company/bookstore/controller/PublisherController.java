package com.company.bookstore.controller;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
    @Autowired
    PublisherRepository repo;

    @GetMapping
    public List<Publisher> getPublishers() {
        return repo.findAll();
    }

    @GetMapping("/{publisher_id}")
    public Publisher getPublisherById(@PathVariable int publisher_id) {
        return repo.findById(publisher_id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return repo.save(publisher);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody Publisher publisher) {
        repo.save(publisher);
    }

    @DeleteMapping("/{publisher_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int publisher_id) {
        repo.deleteById(publisher_id);
    }
}
