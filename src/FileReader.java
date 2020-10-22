import java.io.*;
import java.util.ArrayList;

public class FileReader {

    File file = new File("src/bank.txt");
    java.io.FileReader fr = new java.io.FileReader(file);
    BufferedReader reader = new BufferedReader(fr);

    private final ArrayList<String> bank = new ArrayList<>();

    public ArrayList<String> getBank() {
        return bank;
    }

    public FileReader() throws IOException {
        String word = reader.readLine();
        while (word != null) {
            bank.add(word);
            word = reader.readLine();
        }
    }
}
