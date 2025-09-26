import java.io.*;
import java.util.Scanner;

public class NotesApp {

    static final String FILE = "notes.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n*** My Notes App ***");
            System.out.println("1. Write a note");
            System.out.println("2. Show notes");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            option = sc.nextInt();
            sc.nextLine(); // to catch the newline

            switch (option) {
                case 1:
                    writeNote(sc);
                    break;
                case 2:
                    showNotes();
                    break;
                case 3:
                    System.out.println("Okay, exiting... bye!");
                    break;
                default:
                    System.out.println("Hmm, that's not right. Try again!");
            }

        } while (option != 3);

        sc.close();
    }

    static void writeNote(Scanner sc) {
        System.out.print("Type your note: ");
        String note = sc.nextLine();

        try (FileWriter fw = new FileWriter(FILE, true)) { // append mode
            fw.write(note + "\n");
            System.out.println("Cool! Note saved.");
        } catch (IOException e) {
            System.out.println("Oops, something went wrong!");
        }
    }

    static void showNotes() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            System.out.println("\n--- Here are your notes ---");
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes yet! Go add some.");
        } catch (IOException e) {
            System.out.println("Hmm, couldn't read the notes.");
        }
    }
}
