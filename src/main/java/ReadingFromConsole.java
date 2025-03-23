import java.io.File;
import java.util.Scanner;

public class ReadingFromConsole {
    //Logger logger = LogManager.getLogger(ReadingFromConsole.class.getName());
    Scanner scanner = new Scanner(System.in);
    File file;

    public String readFile() {
        //logger.info("readFile");
        String line;
        line = scanner.nextLine();
        if (checkFile(line)) {
            return line;
        } else
            return "Not found";
    }

    public boolean checkFile(String line) {
        //logger.info("checkFile");
        file = new File(line);
        if (file.isFile()) {
            return true;
        } else {
            return false;
        }
    }
}
