package com.company.bookstore.ControllerTests;
import com.company.bookstore.controller.BookController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.models.Author;
import com.company.bookstore.controller.AuthorController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorRepository authorRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testMagicQuestionResponse() throws Exception {
        Author author = new Author();

        author.setFirstName("Perd");
        author.setLastName("Last");
        author.setStreet("Broad St");
        author.setCity("Savannah");
        author.setState("GA");
        author.setPostalCode("31401");
        author.setPhone("912-555-5555");
        author.setEmail("perd@perdroasters.com");
        String inputJson = mapper.writeValueAsString(author);
        String outputJson = mapper.writeValueAsString(author);

        mockMvc.perform(
                        post("/authors")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }
}
