package self;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

  public static final String BookAlreadyRegistered = "book already registered";
  public static final String BookUnavailable = "book unavailable";
  public static final String BookNotRented = "book not rented";
  public static final String CannotRemoveBookNotRegistered = "cannot remove, book not registered";
  private List<Book> books;
  private List<Book> rented;

  public Library() {
    books = new ArrayList<>();
    rented = new ArrayList<>();
  }

  public void addBook( Book book ) {
    if (books.contains( book ) || rented.contains( book ) ) { 
      throw new RuntimeException(BookAlreadyRegistered);
    }
    books.add( book );
  }
  
  public void rentBook( Book book ) {
    if (!books.contains( book )) {
      throw new RuntimeException(BookUnavailable);
    }
    rented.add( book );
    /*for (int i = 0; i < books.size(); i++) {
      if (books.get( i ).equals( book )) {
        books.remove( i );
        break;
      }
    }*/
    books.remove( book );
  }

  public void returnBook( Book book ) {
    if (!rented.contains( book )) { 
      throw new RuntimeException(BookNotRented);
    }
    books.add( book );
    /*for (int i = 0; i < rented.size(); i++) {
      if (rented.get( i ).equals( book )) {
        rented.remove( i );
        break;
      }
    }*/
    rented.remove( book );
  }

  public void removeBook( Book book ) {
    if (!books.contains( book ) && !rented.contains( book ) ) {
      throw new RuntimeException(CannotRemoveBookNotRegistered);
    }
      /*for (int i = 0; i < books.size(); i++) {
        if (books.get( i ).equals( book )) {
          books.remove( i );
          break;
        }*/
        books.remove( book );
        rented.remove( book );
  }

  public List<Book> searchAvailableByGenre( String genre ) {
    /*for (Book book : books) {
      if (book.getGenre().equals( genre )) { result.add( book ); }
    }*/
    return books.stream().filter( book -> book.getGenre().equals( genre ) ).collect( Collectors.toList() );
  }

  public List<Book> searchAvailableByAuthor( String author ) {
    /*List<Book> result = new ArrayList<>();
    for (Book book : books) {
      if (book.getAuthor().equals( author )) { result.add( book ); }
    }
    return result;*/
    return books.stream().filter( book -> book.getAuthor().equals( author ) ).collect( Collectors.toList() );
  }

  public int available() {
    return books.size();
  }
}
