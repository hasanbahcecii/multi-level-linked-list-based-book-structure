
public class LinkedBook {

    private HeadingNode head;

    public LinkedBook() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirstLevel(int position, String title) {

        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }

        HeadingNode newNode = new HeadingNode(title);

        if (head == null) {
            head = newNode;
            return;
        }

        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        HeadingNode current = head;
        int count = 1;

        while (count < position - 1 && current.next != null) {
            current = current.next;
            count++;
        }

        newNode.next = current.next;
        current.next = newNode;

    }

    public void printFirstLevel() {
        HeadingNode current = head;

        while (current != null) {
            System.out.println(current.title);
            current = current.next;
        }
    }

    public void print() {
        printRecursive(head, "", 0);
    }

    public void printRecursive(HeadingNode node, String prefix, int level) {

        HeadingNode current = node;
        int counter = 1;

        while (current != null) {

            // Girinti üret
            String indent = "";
            for (int i = 0; i < level; i++) {
                indent += "    ";
            }

            String number;
            if (prefix.equals("")) {
                number = "" + counter;

            } else {
                number = prefix + "." + counter;
            }

            System.out.println(indent + number + " " + current.getTitle());

            if (current.child != null) {
                printRecursive(current.child, number, level + 1);
            }

            current = current.next;
            counter++;
        }
    }

    // Verilen seviyede n. sıradaki başlığı bulur
    private HeadingNode findNodeAtPosition(HeadingNode listHead, int n) {
        if (n < 1) {
            return null;
        }

        HeadingNode current = listHead;
        int count = 1;

        while (current != null && count < n) {
            current = current.next;
            count++;
        }

        if (count == n) {
            return current;
        }

        return null;
    }

    public void add(String path, String title) {

        // path format kontrolleri
        if (path == null || path.length() == 0) {
            System.out.println("Invalid path");
            return;
        }

        if (path.startsWith(".") || path.endsWith(".")) {
            System.out.println("Invalid path format");
            return;
        }

        HeadingNode currentListHead = head;
        HeadingNode parentNode = null;

        int currentIndex = 0;
        int i = 0;

        while (i < path.length()) {
            char ch = path.charAt(i);

            if (ch >= '0' && ch <= '9') {
                currentIndex = currentIndex * 10 + (ch - '0');

            } else if (ch == '.') {

                // Nokta geldiyse ama öncesinde sayı yoksa
                if (currentIndex <= 0) {
                    System.out.println("Invalid path format");
                    return;
                }

                HeadingNode found = findNodeAtPosition(currentListHead, currentIndex);

                if (found == null) {
                    System.out.println("Invalid path: parent not found");
                    return;
                }

                parentNode = found;
                currentListHead = parentNode.child;
                currentIndex = 0;

            } else {
                System.out.println("Invalid character in path");
                return;
            }

            i++;
        }

        // son pozisyon kontrolü
        if (currentIndex <= 0) {
            System.out.println("Invalid position");
            return;
        }

        int position = currentIndex;

        // duplicate control
        HeadingNode temp = currentListHead;
        while (temp != null) {
            if (temp.getTitle().equals(title)) {
                System.out.println("Duplicate title on same level");
                return;
            }
            temp = temp.next;
        }

        HeadingNode newNode = new HeadingNode(title);
        newNode.parent = parentNode;

        // seviye boşsa ekleme
        if (currentListHead == null) {
            if (parentNode != null) {
                parentNode.child = newNode;
            } else {
                head = newNode;
            }
            return;
        }

        // başa ekleme
        if (position == 1) {
            newNode.next = currentListHead;
            if (parentNode != null) {
                parentNode.child = newNode;
            } else {
                head = newNode;
            }
            return;
        }

        //  ortaya ve sona ekleme 
        HeadingNode current = currentListHead;
        int count = 1;

        while (current.next != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (count < position - 1) {
            System.out.println(
                    "Since the requested number of headings does not exist at this level, it has been added to the last position"
            );
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Program başında varsayılan olarak oluşturulan ağaç
    public void buildDefaultTree() {

        // 1. Veri Yapıları ve Algoritmalar
        add("1", "Veri Yapıları ve Algoritmalar");
        add("1.1", "Veri Yapısı Nedir");
        add("1.2", "Algoritma Nedir");
        add("1.2.1", "Kaba Kod");
        add("1.2.2", "Akış Şeması");
        add("1.2.3", "Algoritma Analizi");
        add("1.2.3.1", "En İyi Durum Analizi");
        add("1.2.3.2", "Ortalama Durum Analizi");
        add("1.2.3.3", "En Kötü Durum Analizi");

        // 2. Sıralama
        add("2", "Sıralama");
        add("2.1", "Sıralama Nedir");
        add("2.2", "Sıralama Algoritmaları");
        add("2.2.1", "Araya Sokma Sıralaması");
        add("2.2.1.1", "Kaba Kodu");
        add("2.2.1.1.1", "C Kodu");
        add("2.2.1.1.2", "Java Kodu");
        add("2.2.1.1.2.1", "Ekleme");
        add("2.2.1.1.2.2", "Silme");
        add("2.2.2", "Seçmeli Sıralama");
        add("2.2.3", "Kabarcık Sıralama");
        add("2.2.1.2", "Örnekler");
        add("2.2.1.2.1", "Örnek 1");
        add("2.2.1.2.2", "Örnek 2");
        add("2.2.1.3", "Algoritmanın Analizi");

        // 3. Arama
        add("3", "Arama");

        // 4. Ağaçlar
        add("4", "Ağaçlar");
        add("4.1", "Ağaç Nedir");
    }

}
