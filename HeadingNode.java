
public class HeadingNode {

    String title;
    HeadingNode parent;
    HeadingNode next;
    HeadingNode child;

    public HeadingNode(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
