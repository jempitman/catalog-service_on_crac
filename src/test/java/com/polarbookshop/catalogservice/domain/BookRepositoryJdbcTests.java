//package com.polarbookshop.catalogservice.domain;
//
//import com.polarbookshop.catalogservice.config.DataConfig;
//import com.polarbookshop.catalogservice.config.DataSourceConfig;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.context.annotation.Import;
//import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.ActiveProfiles;
//
//import javax.activation.DataSource;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJdbcTest
//@Import({DataConfig.class, DataSourceConfig.class})
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("integration")
//public class BookRepositoryJdbcTests {
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    @Autowired
//    private JdbcAggregateTemplate jdbcAggregateTemplate;
//
//    @Test
//    void findsBookByIsbnWhenExisting(){
//        var bookIsbn = "1234561237";
//        var book = Book.of(bookIsbn, "Title", "Author", 12.90, "Polarsophia");
//        jdbcAggregateTemplate.insert(book);
//        Optional<Book> actualBook = bookRepository.findByIsbn(bookIsbn);
//
//        assertThat(actualBook).isPresent();
//        assertThat(actualBook.get().isbn()).isEqualTo(book.isbn());
//    }
//
//    @Test
//    void findAllBooks(){
//        var book1 = Book.of("1234561235", "Title", "Author", 12.90, "Polarsophia");
//        var book2 = Book.of("1234561236", "Another Title", "Author", 12.90, "Polarsophia");
//
//        jdbcAggregateTemplate.insert(book1);
//        jdbcAggregateTemplate.insert(book2);
//
//        Iterable<Book> actualBooks = bookRepository.findAll();
//
//        assertThat(StreamSupport.stream(actualBooks.spliterator(), true)
//                .filter(book -> book.isbn().equals(book1.isbn()) || book.isbn().equals(book2.isbn()))
//                .collect(Collectors.toList())).hasSize(2);
//    }
//
//    @Test
//    void existsByIsbnWhenNotExisting(){
//        boolean existing = bookRepository.existsByIsbn("1234561240");
//        assertThat(existing).isFalse();
//    }
//
//    @Test
//    void whenCreateBookNotAuthenticatedThenNoAuditMetadata(){
//        var bookToCreate = Book.of("1234561235", "Title",
//                "Author", 12.90, "Polarsophia");
//        var createdBook = bookRepository.save(bookToCreate);
//
//        assertThat(createdBook.createdBy()).isNull();
//        assertThat(createdBook.lastModifiedBy()).isNull();
//    }
//
//    @Test
//    @WithMockUser("john")
//    void whenCreateBookAuthenticatedThenAuditMetaData(){
//        var bookToCreate = Book.of("1234561235", "Title",
//                "Author", 12.90, "Polarsophia");
//        var createdBook = bookRepository.save(bookToCreate);
//
//        assertThat(createdBook.createdBy()).isEqualTo("john");
//        assertThat(createdBook.lastModifiedBy()).isEqualTo("john");
//    }
//}
