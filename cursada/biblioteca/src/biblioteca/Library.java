package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

	public static String bookUnavailable = "book unavailable";
	public static String bookAlreadyRegistered = "book already registered";
	public static String bookNotRented = "book not rented";
	public static String cannotRemoveBookNotRegistered = "cannot remove, book not registered";
	private List<Book> books;
	private List<Book> rented;

	public Library() {
		books = new ArrayList<>();
		rented = new ArrayList<>();
	}

	public void addBook(Book book) {
		if (books.contains(book) || rented.contains(book)) {
			throw new RuntimeException(bookAlreadyRegistered);
		}
		books.add(book);
	}

	public void rentBook(Book book) {
		if (!books.contains(book)) {
			throw new RuntimeException(bookUnavailable);
		}
		rented.add(book);
		books.remove(book);
	}

	public void returnBook(Book book) {
		if (!rented.contains(book)) {
			throw new RuntimeException(bookNotRented);
		}
		books.add(book);
		rented.remove(book);
	}

	public void removeBook(Book book) {

		if (books.contains(book)) {
			books.remove(book);
		}

		else if (rented.contains(book)) {
			rented.remove(book);
		}

		else {
			throw new RuntimeException(cannotRemoveBookNotRegistered);
		}
	}

	public List<Book> searchAvailableByGenre(String genre) {
		return books.stream().filter(book -> book.getGenre().equals(genre)).collect(Collectors.toList());
	}

	public List<Book> searchAvailableByAuthor(String author) {
		return books.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
	}

	public int available() {
		return books.size();
	}
}
