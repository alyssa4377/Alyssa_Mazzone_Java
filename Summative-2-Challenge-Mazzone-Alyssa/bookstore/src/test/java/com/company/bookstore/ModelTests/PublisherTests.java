package com.company.bookstore.ModelTests;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherTests {

        @Autowired
        PublisherRepository pubRepo;


        @Before
        public void setUp() {
            pubRepo.deleteAll();
        }

        @Test
        @Transactional
        public void shouldAddAndFindById() {
            Publisher publisher = new Publisher();

            publisher.setName("Perd");
            publisher.setStreet("Broad St");
            publisher.setCity("Savannah");
            publisher.setState("GA");
            publisher.setPostalCode("31401");
            publisher.setPhone("912-555-5555");
            publisher.setEmail("perd@perdroasters.com");

            pubRepo.save(publisher);



            Publisher fromRepo = pubRepo.findById(publisher.getPublisher_id()).get();
            assertEquals(publisher, fromRepo);
        }

        @Test
        @Transactional
        public void shouldDeleteAuthor() {
            Publisher publisher = new Publisher();

            publisher.setName("Perd");
            publisher.setStreet("Broad St");
            publisher.setCity("Savannah");
            publisher.setState("GA");
            publisher.setPostalCode("31401");
            publisher.setPhone("912-555-5555");
            publisher.setEmail("perd@perdroasters.com");

            pubRepo.save(publisher);


            pubRepo.deleteById(publisher.getPublisher_id());

            Optional<Publisher> fromRepo = pubRepo.findById(publisher.getPublisher_id());
            assertFalse(fromRepo.isPresent());
        }

        @Test
        @Transactional
        public void shouldUpdateAuthor() {
            Publisher publisher = new Publisher();

            publisher.setName("Perd");
            publisher.setStreet("Broad St");
            publisher.setCity("Savannah");
            publisher.setState("GA");
            publisher.setPostalCode("31401");
            publisher.setPhone("912-555-5555");
            publisher.setEmail("perd@perdroasters.com");

            pubRepo.save(publisher);
            Publisher author1 = pubRepo.getOne(publisher.getPublisher_id());

            assertEquals(author1, publisher);
        }

        @Test
        @Transactional
        public void shouldFindByAuthorId() {

            Publisher publisher = new Publisher();
            Publisher publisher2 = new Publisher();

            publisher.setName("Perd");
            publisher.setStreet("Broad St");
            publisher.setCity("Savannah");
            publisher.setState("GA");
            publisher.setPostalCode("31401");
            publisher.setPhone("912-555-5555");
            publisher.setEmail("perd@perdroasters.com");

            pubRepo.save(publisher);

            publisher2.setName("John's");
            publisher2.setStreet("Price St");
            publisher2.setCity("Atlanta");
            publisher2.setState("GA");
            publisher2.setPostalCode("30332");
            publisher2.setPhone("404-555-5555");
            publisher2.setEmail("john@johnsroaster.com");

            pubRepo.save(publisher2);

            pubRepo.findById(publisher.getPublisher_id());
            pubRepo.findById(publisher2.getPublisher_id());
        }
    }




