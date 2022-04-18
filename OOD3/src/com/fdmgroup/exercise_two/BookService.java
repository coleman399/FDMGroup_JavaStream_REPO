

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookService {

    public Book[] filterBooksByAuthor(Author author, Book[] books) {
        // Stream<Book> bookStream = Arrays.stream(books);

        return null;
    }

    public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
        Stream<Book> bookStream = Arrays.stream(books);
        List<Book> result = bookStream.filter(book -> book.getPublisher().equals(publisher))
                .collect(Collectors.toList());
        return result.toArray(new Book[result.size()]);
    }

    // methods keeps books with publishing year inclusively.
    public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
        Stream<Book> bookStream = Arrays.stream(books);
        List<Book> result = bookStream.filter(book -> book.getPublishingYear() == yearFromInclusively)
                .collect(Collectors.toList());
        return result.toArray(new Book[result.size()]);
    }
}
