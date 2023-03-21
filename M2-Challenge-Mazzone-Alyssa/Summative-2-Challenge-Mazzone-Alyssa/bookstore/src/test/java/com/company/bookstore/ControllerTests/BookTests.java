package com.company.bookstore.ControllerTests;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.models.Book;
import com.company.bookstore.controller.BookController;
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
public class BookTests {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testMagicQuestionResponse() throws Exception {
        Book book = new Book();
        book.setBook_id(4);
        book.setIsbn("is bn");
        book.setPublish_date("9/7/2015");
        book.setAuthor_id(1);
        book.setTitle("The best title");
        book.setPrice(9.5f);
        book.setPublisher_id(2);

        String inputJson = mapper.writeValueAsString(book);
        String outputJson = mapper.writeValueAsString(book);

        mockMvc.perform(
                        post("/books")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }
}
