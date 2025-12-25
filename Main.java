
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            LinkedBook book = new LinkedBook();
            book.buildDefaultTree();

            while (true) {
                String line = sc.nextLine();

                if (line.equals("exit")) {
                    break;
                }

                processCommand(line, book);
            }

            sc.close();
        }
    }

    private static void processCommand(String line, LinkedBook book) {

        int i = 0;
        int len = line.length();

        // 1️⃣ Komut oku
        String command = "";
        while (i < len && line.charAt(i) != ' ') {
            command += line.charAt(i);
            i++;
        }

        i++; // boşluğu geç

        // 2️⃣ Path oku
        String path = "";
        while (i < len && line.charAt(i) != ' ') {
            path += line.charAt(i);
            i++;
        }

        i++; // boşluğu geç

        // 3️⃣ Title oku
        String title = "";
        while (i < len) {
            title += line.charAt(i);
            i++;
        }

        // 4️⃣ Komut çalıştır
        if (command.equals("add")) {
            book.add(path, title);
        } else if (command.equals("print")) {
            book.print();
        }
    }

}
