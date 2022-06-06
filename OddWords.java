import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OddWords extends BinarySearchTree {

    public OddWords() {
        super();
    }

    /**
     * Processes a file and prints process and lexicon to console
     * @param fileName
     */
    public void processFile(String fileName) {
        try {
            root = null;

            // File to be read
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] split = str.split(" ");

                for (String s : split) {
                    if (search(s)) {
                        remove(s);
                        System.out.println("DELETED");
                    }
                    else {
                        insert(s);
                        System.out.println(s + " INSERTED");
                    }
                }

                System.out.println("\nLEXICON:");
                dump();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    protected boolean rSearch(BSTNode node, String value) {
        if (node != null) {
            System.out.print(node.value + " ");
        }

        return super.rSearch(node, value);
    }
}
