package tests.day16_Odevler;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;

public class C01_WebTables {

    @Test
    public void test() {
        //Bir class oluşturun : C02_WebTables
        //● login() metodun oluşturun ve oturum açın.
        //● https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        // ○ Username : manager
        // ○ Password : Manager1!
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementLink.click();
        qaConcortPage.hotelRoomsLink.click();

        //● table() metodu oluşturun
        // ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        for (WebElement each: qaConcortPage.basliklarListesi) {
            System.out.println(each.getText());
        }
        System.out.println(qaConcortPage.basliklarListesi.size());

        // ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
            // eger tum tablo body'sini hucrelere ayirmadan tek bir String olarak gormek istersek
            // tum body'i tek bir Webelement olarak locate edebiliriz
            // bu yaklasim tabloda HAPPY HOTEL varm i gibi sorular icin ideal bir cozum olur

        System.out.println(qaConcortPage.tbodyTumu.getText());
        Assert.assertTrue(qaConcortPage.tbodyTumu.getText().contains("HAPPY HOTEL"));

        //● printRows() metodu oluşturun //tr
        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.out.println(qaConcortPage.satirlarListesi.size());

        // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each:qaConcortPage.satirlarListesi) {
            System.out.println(each.getText());
        }

        // eger tum satirlari yazdirmak istersek:
        for (int i = 1; i <= qaConcortPage.satirlarListesi.size() ; i++) {
            System.out.println(i + ". satir: " + qaConcortPage.satirlarListesi.get(i).getText());
        }

        // ○ 4.satirdaki(row) elementleri konsolda yazdırın. (satirlardaki 4. datalari getir):
        for (WebElement each:qaConcortPage.dorduncuSutunListe) {
            System.out.println(each.getText());
        }


    }
}
