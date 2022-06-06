public class BinarySearchTree {

    // Root BSTNode in the tree
    protected BSTNode root;

    /**
     * Initialises a new BinarySearchTree and sets root to null
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Searches for a given value in the tree
     * @param value Value to search for
     * @return Whether or not the given value is contained in the tree
     */
    public boolean search(String value) {
        if (value == null) {
            return false;
        }

        return rSearch(root, value);
    }

    /**
     * Recursive function that checks if the current node equals the given value
     * and calls either the left or right child if it does not equal
     * @param node Current node being checked
     * @param value Value to check for
     * @return Whether this node or any of its children contain the given value
     */
    protected boolean rSearch(BSTNode node, String value) {
        // Returns false if the bottom of the tree has been reached
        if (node == null) {
            return false;
        }

        if (value.equals(node.value)) {
            return true;
        }
        // Checks the left child if value is less than the current node's value
        else if (value.compareTo(node.value) < 0) {
            return rSearch(node.left, value);
        }
        // Otherwise checks the right child
        else {
            return rSearch(node.right, value);
        }
    }

    /**
     * Inserts a given value into the tree
     * @param value Value to insert into the tree
     */
    public void insert(String value) {
        if (value == null) {
            return;
        }

        root = rInsert(root, value);
    }

    /**
     * If the bottom of the tree has been reached, inserts given value into the tree,
     * otherwise continues searching downwards
     * @param node Current node being checked
     * @param value Value to be inserted into the tree
     * @return
     */
    protected BSTNode rInsert(BSTNode node, String value) {
        if (node == null) {
            return new BSTNode(value);
        }

        if (value.compareTo(node.value) < 0) {
            node.left = rInsert(node.left, value);
        }
        else if (value.compareTo(node.value) > 0) {
            node.right = rInsert(node.right, value);
        }

        // Returns without adding if the BST contains an identical string
        return node;
    }

    /**
     * Removes a given value from the tree
     * @param value
     */
    public void remove(String value) {
        if (value == null) {
            return;
        }

        root = rRemove(root, value);
    }

    /**
     * Recursively searches for the BSTNode to be removed
     * @param node Node being checked
     * @param value Value to be removed
     * @return Returns the BSTNode in position after changes
     */
    protected BSTNode rRemove(BSTNode node, String value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.value) < 0) {
            node.left = rRemove(node.left, value);
        }
        else if (value.compareTo(node.value) > 0) {
            node.right = rRemove(node.right, value);
        }
        // Removes value when found
        else {
            // If left is null set right as new parent node
            if (node.left == null) {
                return node.right;
            }
            // If right is null set left as new parent node
            else if (node.right == null) {
                return node.left;
            }
            // If neither is null get smallest node greater than current parent and put in parent position
            else {
                BSTNode front = node.right;
                BSTNode back = null;

                // Gets the smallest value greater than the value being removed
                while (front.left != null) {
                    back = front;
                    front = front.left;
                }

                node.value = front.value;

                if (front == node.right) {
                    node.right = front.right;
                }
                else {
                    back.left = front.right;
                }
            }
        }

        return node;
    }

    /**
     * Writes all values in order to console
     */
    public void dump() {
        rDump(root);
    }

    /**
     * Writes current node's value to console and calls rNode for children
     * @param node Node with value being written to console
     */
    protected void rDump(BSTNode node) {
        if (node == null) {
            return;
        }

        rDump(node.left);
        System.out.println(node.value);
        rDump(node.right);
    }

    /**
     * Gets height of BST
     * @return Height of BST
     */
    public int height() {
        return rHeight(root);
    }

    /**
     * Gets height from current node downwards
     * @param node Node with height being found
     * @return Height of BST from current point downwards
     */
    protected int rHeight(BSTNode node) {
        if (node == null) {
            return -1;
        }

        return Integer.max(rHeight(node.left), rHeight(node.right)) + 1;
    }
}
