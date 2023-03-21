package com.company.bookstore.controller;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphController {

    @Autowired
    PublisherRepository publisherRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

//    @QueryMapping
//    public List<Book> books() {
//        return  bookRepository.getBooks();
//    }
//    @QueryMapping
//    public List<Author> authors() {
//        return  authorRepository.getAuthors();
//    }
//    @QueryMapping
//    public List<Publisher> publishers() {
//        return  publisherRepository.getPublishers();
//    }

    @QueryMapping
    public Author findAuthorById(@Argument int author_id) {return authorRepository.getById(author_id);}
    @QueryMapping
    public Book findBookById(@Argument int book_id) {
        return bookRepository.getById(book_id);
    }
    @QueryMapping
    public Publisher findPublisherById(@Argument int publisher_id) {
        return publisherRepository.getById(publisher_id);
    }
//
//    @MutationMapping
//    public Publisher addPublisher(
//            @Argument int publisher_id,
//            @Argument String name,
//            @Argument String street,
//            @Argument String city,
//            @Argument String state,
//            @Argument String postal_code,
//            @Argument String phone,
//            @Argument String email) {
//        return publisherRepository.addPublisher(publisher_id, name, street, city, state, postal_code, phone, email);
//    }
//
//    @MutationMapping
//    public Publisher updatePublisher(
//            @Argument int publisher_id,
//            @Argument String name,
//            @Argument String street,
//            @Argument String city,
//            @Argument String state,
//            @Argument String postal_code,
//            @Argument String phone,
//            @Argument String email) {
//        Publisher updatedPublisher = new Publisher(publisher_id, name, street, city, state, postal_code, phone, email);
//        return publisherRepository.updatePublisher(updatedPublisher);
//    }
//
//    @MutationMapping
//    public Book addBook(
//            @Argument int book_id,
//            @Argument String isbn,
//            @Argument String publish_date,
//            @Argument int author_id,
//            @Argument String title,
//            @Argument int publisher_id,
//            @Argument double price) {
//        return bookRepository.addBook(book_id, isbn, publish_date, author_id, title, publisher_id, price);
//    }
//
//    @MutationMapping
//    public Book updateBook(
//            @Argument int book_id,
//            @Argument String isbn,
//            @Argument String publish_date,
//            @Argument int author_id,
//            @Argument String title,
//            @Argument publisher_id,
//            @Argument double price) {
//        Book updatedBook = new Book(book_id, isbn, publish_date, author_id, title, publisher_id, price);
//        return bookRepository.updateBook(updatedBook);
//    }
//
//    @MutationMapping
//    public Author addAuthor(
//            @Argument int author_id,
//            @Argument String first_name,
//            @Argument String last_name,
//            @Argument String street,
//            @Argument String city,
//            @Argument String state,
//            @Argument String postal_code,
//            @Argument String phone,
//            @Argument String email) {
//        return authorRepository.addAuthor(author_id, first_name, last_name, street, city, state, postal_code, phone, email);
//    }
//
//    @MutationMapping
//    public Author updateAuthor(
//            @Argument int author_id,
//            @Argument String first_name,
//            @Argument String last_name,
//            @Argument String street,
//            @Argument String city,
//            @Argument String state,
//            @Argument String postal_code,
//            @Argument String phone,
//            @Argument String email) {
//        return authorRepository.updateAuthor(author_id, first_name, last_name, street, city, state, postal_code, phone, email);
//    }
//
//    @MutationMapping
//    public boolean deletePublisherById(@Argument int publisher_id) {
//        return publisherRepository.deletePublisherById(publisher_id);
//    }
//    @MutationMapping
//    public boolean deleteAuthorById(@Argument int author_id) {
//        return authorRepository.deleteAuthorById(author_id);
//    }
//    @MutationMapping
//    public boolean deleteBookById(@Argument int book_id) {
//        return bookRepository.deleteBookById(book_id);
//    }

}
