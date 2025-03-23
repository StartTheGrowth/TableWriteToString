import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertTable {
    //Logger logger = LogManager.getLogger(ConvertTable.class.getName());
    private String readableFile;
    private String writableFile;

    public ConvertTable(String readableFile, String writableFile) throws IOException {
        //logger.info("Constructor ConvertTable");
        this.readableFile = readableFile;
        this.writableFile = writableFile;
        rewrite();
    }

    public void rewrite() throws IOException {
       // logger.info("rewrite");
        File file = new File(readableFile);
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(1);
        Iterator<Row> rowIterator = sheet.iterator();
        FileOutputStream fileOutputStream = new FileOutputStream(writableFile);
        rowIterator.next();
        int i = 0;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                i++;
                Cell cell = cellIterator.next();
                String line = cell.toString() + " ";
                String transition = "\n";
                Pattern pattern = Pattern.compile("-?\\d+\\.?\\d*");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String numString = matcher.group();
                    double numDouble = Double.parseDouble(numString);
                    int numInt = (int) numDouble;
                    line = numInt + " ";
                }
                fileOutputStream.write(line.getBytes());
                if (i == row.getLastCellNum()) {
                    i = 0;
                    fileOutputStream.write(transition.getBytes());
                }
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
        System.out.println("Копирование завершено");
    }
}