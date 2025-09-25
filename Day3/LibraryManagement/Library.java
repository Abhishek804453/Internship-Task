import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " added to library.");
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println(user.getName() + " registered.");
    }

    public void issueBook(int bookId, int userId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (!book.isIssued()) {
                    book.setIssued(true);
                    System.out.println(book.getTitle() + " issued to user " + userId);
                } else {
                    System.out.println(book.getTitle() + " is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (book.isIssued()) {
                    book.setIssued(false);
                    System.out.println(book.getTitle() + " returned.");
                } else {
                    System.out.println(book.getTitle() + " was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void showBooks() {
        System.out.println("\nBooks in library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showUsers() {
        System.out.println("\nUsers:");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
