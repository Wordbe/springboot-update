package co.wordbe.thejavaspringboot;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BookServiceTest {

    @Test
    public void di() {
        BookRepository bookRepositoryMock = mock(BookRepository.class);
        Book hibernateBook = new Book();
        hibernateBook.setTitle("mock object hibernateBook");
        when(bookRepositoryMock.save(any())).thenReturn(hibernateBook);

        BookService bookService = new BookService(bookRepositoryMock);

        Book book = new Book();
        book.setTitle("봄날");
        bookService.rent(book);
        bookService.returnBook(book);
    }
}