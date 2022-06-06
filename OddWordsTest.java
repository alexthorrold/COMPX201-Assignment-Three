import org.junit.jupiter.api.*;
import java.io.*;

class OddWordsTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setOut() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Testing the processFile() method where file is empty")
    public void testProcessEmptyFile() {
        // Assign
        OddWords ow = new OddWords();
        // Act
        ow.processFile("test_file_empty.txt");
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(actual, "");
    }

    @Test
    @DisplayName("Testing the processFile() method where file has no duplicates")
    public void testProcessNoDuplicates() {
        // Assign
        OddWords ow = new OddWords();
        // Act
        ow.processFile("test_file_no_duplicates.txt");
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(actual, """
                the INSERTED\r
                the quick INSERTED\r
                the quick brown INSERTED\r
                
                LEXICON:\r
                brown\r
                quick\r
                the""");
    }

    @Test
    @DisplayName("Testing the processFile() method where file has duplicates")
    public void testProcessWithDuplicates() {
        // Assign
        OddWords ow = new OddWords();
        // Act
        ow.processFile("test_file_with_duplicates.txt");
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(actual, """
                the INSERTED\r
                the DELETED\r
                quick INSERTED\r
                quick DELETED\r
                brown INSERTED\r
                brown DELETED\r
                                
                LEXICON:""");
    }

    @Test
    @DisplayName("Testing the processFile() method where file has words with odd and even number of occurences")
    public void testProcessWithVariance() {
        // Assign
        OddWords ow = new OddWords();
        // Act
        ow.processFile("test_file_with_variance.txt");
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(actual, """
                the INSERTED\r
                the quick INSERTED\r
                the quick DELETED\r
                the brown INSERTED\r
                the brown fox INSERTED\r
                the brown fox DELETED\r
                                
                LEXICON:\r
                brown\r
                the""");
    }
}