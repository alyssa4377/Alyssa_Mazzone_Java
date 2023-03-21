package com.company.bookstore.ControllerTests;
import com.company.bookstore.controller.BookController;
import com.company.bookstore.models.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import com.company.bookstore.repository.PublisherRepository;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.controller.PublisherController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class PublisherTests {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testMagicQuestionResponse() throws Exception {
        Publisher publisher = new Publisher();

        publisher.setName("Perd");
        publisher.setStreet("Broad St");
        publisher.setCity("Savannah");
        publisher.setState("GA");
        publisher.setPostal_code("31401");
        publisher.setPhone("912-555-5555");
        publisher.setEmail("perd@perdroasters.com");


        String inputJson = mapper.writeValueAsString(publisher);
        String outputJson = mapper.writeValueAsString(publisher);

        mockMvc.perform(
                        post("/publishers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }
}
