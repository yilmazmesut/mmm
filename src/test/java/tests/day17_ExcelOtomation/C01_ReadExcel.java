package tests.day17_ExcelOtomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test() throws IOException {

        // . Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/test/java/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //10. WorkbookFactory.create(fileInputStream)

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");

        //12. Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(2);

        //13. Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3);

        System.out.println(cell);
    }

    @Test
    public void test2() throws IOException {
        // . Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/test/java/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //10. WorkbookFactory.create(fileInputStream)

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)

        //12. Row objesi olusturun sheet.getRow(index)

        //13. Cell objesi olusturun row.getCell(index)
        Cell cell = workbook.getSheet("Sayfa1").getRow(5).getCell(3);

        System.out.println(cell);
    }
}
