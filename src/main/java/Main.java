import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Укажите путь к таблице");
        Scanner scanner = new Scanner(System.in);
        String readableFile = scanner.nextLine();
        System.out.println("Укажите путь к файлу копирования данных");
        String writableFile = scanner.nextLine();
        ConvertTable convertTable = new ConvertTable(readableFile, writableFile);
        System.out.println("Копирование завершено");
    }
}