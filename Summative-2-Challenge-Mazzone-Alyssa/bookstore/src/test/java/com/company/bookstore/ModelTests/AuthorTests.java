package com.company.bookstore.ModelTests;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.models.Author;
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
public class AuthorTests {

    @Autowired
    AuthorRepository authorRepo;


    @Before
    public void setUp() {
        authorRepo.deleteAll();
    }

    @Test
    @Transactional
    public void shouldAddAndFindById() {
        Author author = new Author();

        author.setFirstName("Perd");
        author.setLastName("Last");
        author.setStreet("Broad St");
        author.setCity("Savannah");
        author.setState("GA");
        author.setPostalCode("31401");
        author.setPhone("912-555-5555");
        author.setEmail("perd@perdroasters.com");

        authorRepo.save(author);



        Author fromRepo = authorRepo.findById(author.getAuthorId()).get();
        assertEquals(author, fromRepo);
    }

    @Test
    @Transactional
    public void shouldDeleteAuthor() {
        Author author = new Author();

        author.setFirstName("Perd");
        author.setLastName("Last");
        author.setStreet("Broad St");
        author.setCity("Savannah");
        author.setState("GA");
        author.setPostalCode("31401");
        author.setPhone("912-555-5555");
        author.setEmail("perd@perdroasters.com");

        authorRepo.save(author);


        authorRepo.deleteById(author.getAuthorId());

        Optional<Author> fromRepo = authorRepo.findById(author.getAuthorId());
        assertFalse(fromRepo.isPresent());
    }

    @Test
    @Transactional
    public void shouldUpdateAuthor() {
        Author author = new Author();

        author.setFirstName("Perd");
        author.setLastName("Last");
        author.setStreet("Broad St");
        author.setCity("Savannah");
        author.setState("GA");
        author.setPostalCode("31401");
        author.setPhone("912-555-5555");
        author.setEmail("perd@perdroasters.com");

        authorRepo.save(author);




        Author author1 = authorRepo.getOne(author.getAuthorId());

        assertEquals(author1, author);
    }

    @Test
    @Transactional
    public void shouldFindByAuthorId() {

        Author author = new Author();
        Author author2 = new Author();

        author.setFirstName("Perd");
        author.setLastName("Last");
        author.setStreet("Broad St");
        author.setCity("Savannah");
        author.setState("GA");
        author.setPostalCode("31401");
        author.setPhone("912-555-5555");
        author.setEmail("perd@perdroasters.com");

        authorRepo.save(author);

        author2.setFirstName("John's");
        author2.setLastName("LastSecond");
        author2.setStreet("Price St");
        author2.setCity("Atlanta");
        author2.setState("GA");
        author2.setPostalCode("30332");
        author2.setPhone("404-555-5555");
        author2.setEmail("john@johnsroaster.com");

        authorRepo.save(author2);

        authorRepo.findById(author.getAuthorId());
        authorRepo.findById(author2.getAuthorId());
    }
}
