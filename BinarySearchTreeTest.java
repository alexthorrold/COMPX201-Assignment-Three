import org.junit.jupiter.api.*;
import java.io.*;

class BinarySearchTreeTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setOut() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Testing the search() method with input that is in BST")
    public void testSearchWithValue() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("A");
        boolean actual = bst.search("A");
        // Assert
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("Testing the search() method with input that is not in BST")
    public void testSearchWithoutValue() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("A");
        boolean actual = bst.search("B");
        // Assert
        Assertions.assertFalse(actual);
    }

    @Test
    @DisplayName("Testing the search() method for the left child of root")
    public void testSearchForLeftChild() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("B");
        bst.insert("A");
        boolean actual = bst.search("A");
        // Assert
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("Testing the search() method for the right child of root")
    public void testSearchForRightChild() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("A");
        bst.insert("B");
        boolean actual = bst.search("B");
        // Assert
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("Testing the search() method before anything is input into BST")
    public void testSearchBeforeInsertion() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        boolean actual = bst.search("A");
        // Assert
        Assertions.assertFalse(actual);
    }

    @Test
    @DisplayName("Testing the search() method using a null string")
    public void testSearchUsingNullString() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        // Added value so that rSearch doesn't immediately return due to null BSTNode
        bst.insert("A");
        boolean actual = bst.search(null);
        // Assert
        Assertions.assertFalse(actual);
    }

    @Test
    @DisplayName("Testing the insert() method using the search() method")
    public void testInsertUsingSearch() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("A");
        boolean actual = bst.search("A");
        // Assert
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("Testing the insert() method using the dump() method")
    public void testInsertUsingDump() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("A");
        bst.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(actual, "A");
    }

    @Test
    @DisplayName("Testing the insert() method using an input that the BST already contains")
    public void testInsertDuplicateInput() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("A");
        bst.insert("A");
        bst.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(actual, "A");
    }

    @Test
    @DisplayName("Testing the insert() method using a null input")
    public void testInsertNullInput() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert(null);
        bst.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(actual, "");
    }

    @Test
    @DisplayName("Testing the remove() method using search()")
    public void testRemoveUsingSearch() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("A");
        bst.remove("A");
        boolean actual = bst.search("A");
        // Assert
        Assertions.assertFalse(actual);
    }

    @Test
    @DisplayName("Testing the remove() method using dump()")
    public void testRemoveUsingDump() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("A");
        bst.remove("A");
        bst.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(actual, "");
    }

    @Test
    @DisplayName("Testing the remove() method with an empty BST")
    public void testRemoveEmptyBST() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.remove("A");
        bst.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(actual, "");
    }

    @Test
    @DisplayName("Testing the remove() method where the node only has a left child")
    public void testRemoveNodeWithOnlyLeftChild() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("B");
        bst.insert("A");
        bst.remove("B");
        bst.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(actual, "A");
    }

    @Test
    @DisplayName("Testing the remove() method where the node only has a right child")
    public void testRemoveNodeWithOnlyRightChild() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("A");
        bst.insert("B");
        bst.remove("A");
        bst.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(actual, "B");
    }

    @Test
    @DisplayName("Testing the remove() method where the node has two children")
    public void testRemoveNodeWithTwoChildren() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("B");
        bst.insert("A");
        bst.insert("D");
        bst.insert("C");
        bst.remove("B");
        bst.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(actual, "A\r\nC\r\nD");
    }

    @Test
    @DisplayName("Testing the dump() method with an empty BST")
    public void testDumpEmptyBST() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(actual, "");
    }

    @Test
    @DisplayName("Testing the dump() method with one value in BST")
    public void testDumpOneNode() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("A");
        bst.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(actual, "A");
    }

    @Test
    @DisplayName("Testing the dump() method where the root has children in BST")
    public void testDumpWithChildren() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");
        bst.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(actual,
                """
                        A\r
                        B\r
                        C""");
    }

    @Test
    @DisplayName("Testing the dump() method dumps in order correctly")
    public void testDumpInOrder() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("G");
        bst.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(actual,
                """
                        A\r
                        B\r
                        C\r
                        D\r
                        E\r
                        F\r
                        G""");
    }

    @Test
    @DisplayName("Testing the height() method for an empty BST")
    public void testHeightEmptyBST() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        int actual = bst.height();
        // Assert
        Assertions.assertEquals(actual, -1);
    }

    @Test
    @DisplayName("Testing the height() method for a BST with only root")
    public void testHeightRootOnlyBST() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("A");
        int actual = bst.height();
        // Assert
        Assertions.assertEquals(actual, 0);
    }

    @Test
    @DisplayName("Testing the height() method for a BST with root children")
    public void testHeightWithChild() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("B");
        bst.insert("A");
        int actual = bst.height();
        // Assert
        Assertions.assertEquals(actual, 1);
    }

    @Test
    @DisplayName("Testing the height() method for a BST with two children with different heights")
    public void testHeightDifferentHeightChildren() {
        // Assign
        BinarySearchTree bst = new BinarySearchTree();
        // Act
        bst.insert("D");
        bst.insert("B");
        bst.insert("A");
        bst.insert("F");
        int actual = bst.height();
        // Assert
        Assertions.assertEquals(actual, 2);
    }
}