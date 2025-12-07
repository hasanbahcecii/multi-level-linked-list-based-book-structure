public class HeadingNode {

    private String title;
    private HeadingNode parent;
    private HeadingNode next;
    private HeadingNode child;

    public HeadingNode(String title)
    {
        this.title = title;
        this.parent = null;
        this.child = null;
        this.next = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HeadingNode getParent() {
        return parent;
    }

    public void setParent(HeadingNode parent) {
        this.parent = parent;
    }

    public HeadingNode getNext() {
        return next;
    }

    public void setNext(HeadingNode next) {
        this.next = next;
    }

    public HeadingNode getChild() {
        return child;
    }

    public void setChild(HeadingNode child) {
        this.child = child;
    }
}
