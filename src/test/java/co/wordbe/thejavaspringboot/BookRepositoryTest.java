package co.wordbe.thejavaspringboot;

import co.wordbe.thejavaspringboot.book.Book;
import co.wordbe.thejavaspringboot.book.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void di() {
        assertNotNull(bookRepository);

        Book book = new Book();
        book.setTitle("봄날");
        bookRepository.save(book);

        bookRepository.findAll();
    }
}