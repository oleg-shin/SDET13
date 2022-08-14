package com.syntax.class01;
import org.apache.poi.xss.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\Oleg\\Downloads\\Test.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
    }
}
