import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        // Sample books
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(3, "1984", "George Orwell"));
        books.add(new Book(4, "Pride and Prejudice", "Jane Austen"));
        books.add(new Book(5, "The Catcher in the Rye", "J.D. Salinger"));
        books.add(new Book(6, "The Hobbit", "J.R.R. Tolkien"));
        books.add(new Book(7, "Moby Dick", "Herman Melville"));
        books.add(new Book(8, "War and Peace", "Leo Tolstoy"));
        books.add(new Book(9, "Crime and Punishment", "Fyodor Dostoevsky"));
        books.add(new Book(10, "The Odyssey", "Homer"));

        // Sort books by title for binary search
        Collections.sort(books, Comparator.comparing(Book::getTitle));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the title of the book you want to search for:");
        String title = scanner.nextLine();

        // Linear Search
        Book linearSearchResult = linearSearchByTitle(books, title);
        if (linearSearchResult != null) {
            System.out.println("Linear Search: Found book - " + linearSearchResult);
        } else {
            System.out.println("Linear Search: Book not found.");
        }

        // Binary Search
        Book binarySearchResult = binarySearchByTitle(books, title);
        if (binarySearchResult != null) {
            System.out.println("Binary Search: Found book - " + binarySearchResult);
        } else {
            System.out.println("Binary Search: Book not found.");
        }

        scanner.close();
    }

    // Linear search implementation
    public static Book linearSearchByTitle(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search implementation
    public static Book binarySearchByTitle(List<Book> books, String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);

            int comparison = midBook.getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return midBook;
            }
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}