package co.wordbe.thejavaspringboot;

public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void rent(Book book) {
        Book save = bookRepository.save(book);
        System.out.println("rent: " + save.getTitle());
    }

    public void returnBook(Book book) {
        bookRepository.save(book);
    }
}
