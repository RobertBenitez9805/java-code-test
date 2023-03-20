import java.io.*;
import java.util.Scanner;

public class BatchController {

    private final String filename;
    private String searchCriteria;
    private String searchValue;


    public BatchController(String filename, String searchCriteria, String searchValue) {
        this.filename = filename;
        this.searchCriteria = searchCriteria;
        this.searchValue = searchValue;
    }

    void processFile() {
        String line;
        char formatType = '*'; // F1 or F2

        try {
            Scanner scanner = new Scanner(new File(this.filename));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if(line.startsWith("F")){
                    formatType = line.charAt(1);
                    continue;
                }

                switch (formatType){
                    case '1':
                        Search.search(line, this.searchCriteria, this.searchValue, formatType);
                        break;

                    case '2':

                        // Delete '-' from line
                        StringBuilder sb = new StringBuilder(line);
                        sb.deleteCharAt(sb.lastIndexOf("-"));
                        line = sb.toString();

                        Search.search(line, searchCriteria, searchValue, formatType);
                        break;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
