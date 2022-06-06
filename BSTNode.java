public class BSTNode {

    // Value stored in the node
    public String value;

    // Left child BSTNode
    public BSTNode left;

    // Right child BSTNode
    public BSTNode right;

    /**
     * Initialises a new BSTNode with given value and sets left and right children to null
     * @param value Value to be assigned to this node
     */
    public BSTNode(String value) {
        this.value = value;
        left = null;
        right = null;
    }
}
