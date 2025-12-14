
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

    public void printAll() {
        printRecursive(head, 0);
    }

    public void printRecursive(HeadingNode node, int level) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print(" ");
        }

        System.out.println(node.title);

        if (node.child != null) {
            printRecursive(node.child, level + 1); // level + 1 çünkü alt seviye bir girinti daha derindir.
        }

        if (node.next != null) {
            printRecursive(node.next, level);
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
