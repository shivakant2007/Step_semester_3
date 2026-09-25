// LibraryBook.java
public class LibraryBook {
    String title;
    String author;
    String isbn;

    public LibraryBook(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public LibraryBook(String title) {
        this(title, "PENDING");
    }

    public static void main(String[] args) {
        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"978-0132350884", "", "9780451524935", ""};
        for (int i = 0; i < titles.length; i++) {
            LibraryBook book = new LibraryBook(titles[i], isbns[i]);
            System.out.println(book.title + " | " + book.isbn + " | Catalogued: " + (book.isbn != null && !book.isbn.isEmpty()));
        }
    }
}
