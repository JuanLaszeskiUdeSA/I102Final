package biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

public class LibraryTest {

    @Test public void testNewLibraryHasNoAuthors() {assertTrue(new Library().searchAvailableByAuthor("Anonimous").isEmpty());}

    @Test
    public void testNewLibraryHasNoGenres() {
        assertTrue(new Library().searchAvailableByGenre("SiFy").isEmpty());
    }

    @Test public void testNewLibraryHasNoStock() {
        assertEquals(0, new Library().available());
    }

    @Test public void testLibraryWhitABookHasStock() {
        assertEquals(1, libraryWithABook().available());
    }

    @Test public void testLibraryWhitABookFindsItsGenre() {
        assertTrue(libraryWithABook().searchAvailableByGenre(java4Dummies().getGenre()).contains(java4Dummies()));
    }

    @Test
    public void testLibraryWhitABookFindsItsAuthor() {
        assertTrue(libraryWithABook().searchAvailableByAuthor(java4Dummies().getAuthor()).contains(java4Dummies()));
    }

    @Test public void testLibraryWhitABookRemoved() {
        Library library = libraryWithABook();

        assertEquals(1, library.available());
        library.removeBook(java4Dummies());

        assertEquals(0, library.available());
    }

    @Test
    public void testLibraryWhitNoBooktoRemove() {
        assertThrowsLike(() -> new Library().removeBook(java4Dummies()), Library.cannotRemoveBookNotRegistered);
    }

    @Test public void testLibraryWhitTwiceABook() {
        Library library = libraryWithABook();

        assertThrowsLike(() -> library.addBook(java4Dummies()), Library.bookAlreadyRegistered);
        assertEquals(1, library.available());
    }

    @Test
    public void testFiltersAuthorsOnLibrary() {
        Library library = libraryWithThreeBooks();

        assertEquals(3, library.available());
        assertBooksForFiltersTests(library.searchAvailableByAuthor("Martin Fowler"), java4Dummies(), tolkienUniverse(), pythonForDummies());
    }

    @Test
    public void testFiltersGenreOnLibrary() {
        Library library = libraryWithThreeBooks();

        assertEquals(3, library.available());
        assertBooksForFiltersTests(library.searchAvailableByGenre("IT"), java4Dummies(), pythonForDummies(), tolkienUniverse());
    }

    @Test public void testSucessfulRent() {
        Library library = libraryWithABook();
        library.rentBook(java4Dummies());

        assertEquals(0, library.available());
    }

    @Test public void testUnexistentRent() {
        assertThrowsLike(() -> new Library().rentBook(java4Dummies()), Library.bookUnavailable);
    }

    @Test public void testRentTwice() {
        Library library = libraryWithABook();
        library.rentBook(java4Dummies());

        assertThrowsLike(() -> library.rentBook(java4Dummies()), Library.bookUnavailable);
    }

    @Test public void testRestoreRented() {
        Library library = libraryWithABook();
        library.rentBook(java4Dummies());
        library.returnBook(java4Dummies());

        assertEquals(1, library.available());
    }

    @Test public void testRestoreUnrented() {
        Library library = libraryWithABook();

        assertThrowsLike(() -> library.returnBook(java4Dummies()), Library.bookNotRented);

        assertEquals(1, library.available());
    }

    @Test
    public void testLibraryWhitARentedBookRemoved() {
        Library library = libraryWithABook();
        library.rentBook(java4Dummies());
        library.removeBook(java4Dummies());

        assertThrowsLike(() -> library.returnBook(java4Dummies()), Library.bookNotRented);
    }

    private Book java4Dummies() {
        return new Book("Martin Fowler", "Java4Dummies", "IT");
    }
    private Book pythonForDummies() {
        return new Book("Chamond Liu", "PythonForDummies", "IT");
    }
    private Book tolkienUniverse() {return new Book("Martin Fowler", "TolkienUniverse", "SiFi");}
    private Library libraryWithABook() {
        Library library = new Library();
        library.addBook(java4Dummies());
        return library;
    }
    private Library libraryWithThreeBooks() {
        Library library = libraryWithABook();
        library.addBook(pythonForDummies());
        library.addBook(tolkienUniverse());
        return library;
    }

    private void assertThrowsLike(Executable executable, String message) {
        assertEquals(message, assertThrows(Exception.class, executable).getMessage());
    }

    private void assertBooksForFiltersTests(List<Book> library, Book anExpectedBook, Book anotherExpectedBook, Book notExpectedbook) {
        assertTrue(library.contains(anExpectedBook));
        assertTrue(library.contains(anotherExpectedBook));
        assertFalse(library.contains(notExpectedbook));
    }
}
