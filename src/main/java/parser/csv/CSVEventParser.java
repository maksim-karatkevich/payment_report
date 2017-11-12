package parser.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

/**
 * Created by Maksim on 11/12/2017.
 */
public class CSVEventParser {
    public static void main(String[] args) throws IOException {
        Reader in = new FileReader("E:\\ideaProject\\paymantreport\\src\\main\\resources\\Vpsk_67397755.csv");
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for (CSVRecord record : records) {
            System.out.println(record);
        }
    }

}
