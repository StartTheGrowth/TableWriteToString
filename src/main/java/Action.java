import java.io.IOException;

public class Action {
    //Logger logger = LogManager.getLogger(Action.class.getName());
    String readableFile;
    String writableFile;
    boolean isAction;

    void messageFirst() {
        System.out.println("Введите путь к таблице");
    }

    void messageSecond() {
        System.out.println("Ввведите путь к файлу");
    }

    void messageError() {
        System.out.println("Неверно указан путь");
    }

    void action() throws IOException {
        //logger.info("action");
        isAction = true;
        while (isAction) {
            ReadingFromConsole readingFromConsole = new ReadingFromConsole();
            messageFirst();
            readableFile = readingFromConsole.readFile();
            checkInput(readableFile);
            messageSecond();
            writableFile = readingFromConsole.readFile();
            checkInput(writableFile);
            ConvertTable convertTable = new ConvertTable(readableFile, writableFile);
        }
    }
    void checkInput(String a) throws IOException {
        //logger.info("checkInput");
        if (a.equals("Not found")){
            messageError();
            action();
        }
    }
}
