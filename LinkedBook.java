
public class LinkedBook {

    private HeadingNode head;

    public LinkedBook() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirstLevel(int position, String title) {

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
        printRecursive(head, "");
    }

    public void printRecursive(HeadingNode node, String prefix) {

        HeadingNode current = node;
        int counter = 1;

        while (current != null) {
            String number;
            if (prefix.equals("")) {
                number = "" + counter;

            } else {
                number = prefix + "." + counter;
            }

            System.out.println(number + " " + current.getTitle());

            if (current.child != null) {
                printRecursive(current.child, number);
            }

            current = current.next;
            counter++;
        }
    }

    private HeadingNode getNthNodeAtLevel(HeadingNode listHead, int n) {
        if (n < 1) {
            return null;
        }

        HeadingNode current = listHead;
        int count = 1;

        while (current != null) {
            current = current.next;
            count++;
        }

        if (count == n) {
            return current;
        }

        return null;
    }

    public void add(String path, String title) {

        HeadingNode currentListHead = head; // o anki seviye
        HeadingNode parentNode = null;          // bir üst seviye

        int currentIndex = 0;  // charAt ile oluşan sayı
        int i = 0;             // string index

        while (i < path.length()) {
            char ch = path.charAt(i);

            if (ch >= '0' && ch <= '9') {
                currentIndex = currentIndex * 10 + (ch - '0');
            } else if (ch == '.') {

                HeadingNode found = getNthNodeAtLevel(currentListHead, currentIndex);

                if (found == null) {
                    return;
                }

                parentNode = found;
                currentListHead = parentNode.child;

                currentIndex = 0;
            }
            i++;
        }

        int position = currentIndex;

        HeadingNode temp = currentListHead;
        while (temp != null) {
            if (temp.getTitle().equals(title)) {
                return;
            }

            temp = temp.next;
        }

        HeadingNode newNode = new HeadingNode(title);
        newNode.parent = parentNode;

        if (currentListHead == null) {
            if (parentNode != null) {
                parentNode.child = newNode;
            } else {
                head = newNode;
            }

            return;
        }

        if (position == 1) {
            newNode.next = currentListHead;

            if (parentNode != null) {
                parentNode.child = newNode;
            } else {
                head = newNode;
            }
            return;
        }

        HeadingNode current = currentListHead;
        int count = 0;

        while (current.next != null && count < position - 1) {
            current = current.next;
            count++;
        }

        newNode.next = current.next;
        current.next = newNode;

    }

}
