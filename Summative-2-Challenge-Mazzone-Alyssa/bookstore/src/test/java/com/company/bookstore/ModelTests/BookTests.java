package com.company.bookstore.ModelTests;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.models.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTests {
    @Autowired
    BookRepository bookRepo;


    @Before
    public void setUp() {
        bookRepo.deleteAll();
    }

    @Test
    @Transactional
    public void shouldAddAndFindById() {
        Book book = new Book();
        book.setBook_id(4);
        book.setIsbn("is bn");
        book.setPublish_date("9/7/2015");
        book.setAuthor_id(1);
        book.setTitle("The best title");
        book.setPrice(9.5f);
        book.setPublisher_id(2);

        bookRepo.save(book);



        Book fromRepo = bookRepo.findById(book.getBook_id()).get();
        assertEquals(book, fromRepo);
    }

    @Test
    @Transactional
    public void shouldDeleteAuthor() {
        Book book = new Book();
        book.setBook_id(4);
        book.setIsbn("is bn");
        book.setPublish_date("9/7/2015");
        book.setAuthor_id(1);
        book.setTitle("The best title");
        book.setPrice(9.5f);
        book.setPublisher_id(2);

        bookRepo.save(book);


        bookRepo.deleteById(book.getBook_id());

        Optional<Book> fromRepo = bookRepo.findById(book.getBook_id());
        assertFalse(fromRepo.isPresent());
    }


    @Test
    @Transactional
    public void shouldUpdateAuthor() {
        Book book = new Book();
        book.setBook_id(4);
        book.setIsbn("is bn");
        book.setPublish_date("9/7/2015");
        book.setAuthor_id(1);
        book.setTitle("The best title");
        book.setPrice(9.5f);
        book.setPublisher_id(2);

        bookRepo.save(book);

        Book book1 = bookRepo.getOne(book.getBook_id());

        assertEquals(book1, book);
    }

    @Test
    @Transactional
    public void shouldFindByAuthorId() {
        Book book = new Book();
        Book book1 = new Book();


        book.setBook_id(4);
        book.setIsbn("is bn");
        book.setPublish_date("9/7/2015");
        book.setAuthor_id(1);
        book.setTitle("The best title");
        book.setPrice(9.5f);
        book.setPublisher_id(2);

        bookRepo.save(book);


        book1.setBook_id(4);
        book1.setIsbn("is bn");
        book1.setPublish_date("9/7/2015");
        book1.setAuthor_id(1);
        book1.setTitle("The best title");
        book1.setPrice(9.5f);
        book1.setPublisher_id(2);

        bookRepo.save(book1);

        bookRepo.findById(book.getBook_id());
        bookRepo.findById(book1.getBook_id());

        assertEquals(bookRepo.findById(book.getBook_id()), book);
        assertEquals(bookRepo.findById(book1.getBook_id()), book1);

    }

}
