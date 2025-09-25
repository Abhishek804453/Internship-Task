public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books
        library.addBook(new Book(1, "Java Programming", "Author A"));
        library.addBook(new Book(2, "Data Structures", "Author B"));
        library.addBook(new Book(3, "Algorithms", "Author C"));

        // Add users
        library.addUser(new User(101, "Abhishek"));
        library.addUser(new User(102, "Rohit"));

        // Issue books
        library.issueBook(1, 101);
        library.issueBook(2, 102);

        // Attempt to issue an already issued book
        library.issueBook(1, 102);

        // Return books
        library.returnBook(1);

        // Issue again after return
        library.issueBook(1, 102);

        // --- Adding NEW book and user ---
        library.addBook(new Book(4, "Operating Systems", "Author D"));
        library.addUser(new User(103, "Sakshi"));

        // Issue new book to new user
        library.issueBook(4, 103);

        // Return new book
        library.returnBook(4);

        // Display all books and users
        library.showBooks();
        library.showUsers();
    }
}
