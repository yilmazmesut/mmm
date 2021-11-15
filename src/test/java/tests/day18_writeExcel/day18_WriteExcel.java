package tests.day18_writeExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class day18_WriteExcel {

    @Test
    public void test() throws IOException {
        //1) Yeni bir Class olusturalim WriteExcel
        //2) Yeni bir test method olusturalim writeExcelTest()
        //3) Adimlari takip ederek 1.satira kadar gidelim
        String path = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);    // var olan exceli almadik, yeni bir workbook olusturduk, bir kopyasini buraya aldik
        // ulkeler.xlsx excelli uzak repository'mizdir, bir uzak kopyasini kendimize pull ettik. yani clone'ladik.
        // okudugu zaman sadece ulkeler excel'inin sadece icerisinde veri bulunduran dolu kisimlarini clone'lar.
        // okunmayan bos sutuna ulasamayiz. bu hucreye ulasabilmek icin createCell() ile bu hucreyi olusturmam lazim
        // sonra o hucreye setCellValue() ile deger gondermem gerek.
        // bunu

        //4) 4.hucreye yeni bir cell olusturalim
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1500000");

        //7) 10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("2500000");
        //8) 15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54000");


        //8) 15.satir nufus kolonuna yazdirdigimizi geri silelim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("");

        //9) Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);

        //10)Dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();

    }
}
