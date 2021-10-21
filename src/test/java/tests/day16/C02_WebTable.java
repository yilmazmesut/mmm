package tests.day16;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class C02_WebTable {

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
        for (WebElement each : qaConcortPage.basliklarListesi) {
            System.out.println(each.getText());
        }   // tablonun basligindaki data(satir) lari basliklarListesi'ne attik
        System.out.println("Toblodaki surunlarin sayisi: " + qaConcortPage.basliklarListesi.size());  // sutun sayisini yazdirdik

        // ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        // eger tum tablo body'sini hucrelere ayirmadan tek bir String olarak gormek istersek
        // tum body'i tek bir Webelement olarak locate edebiliriz
        // bu yaklasim tabloda HAPPY HOTEL varm i gibi sorular icin ideal bir cozum olur
        System.out.println(qaConcortPage.tbodyTumu.getText());  // tamamini tek bir string'in icinde yazdirir.
        Assert.assertTrue(qaConcortPage.tbodyTumu.getText().contains("HAPPY HOTEL"));

        //● printRows() metodu oluşturun //tr
        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.out.println(qaConcortPage.satirlarListesi.size());

        // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        System.out.println(qaConcortPage.birinciSatir.getText());

        // eger tum satirlari yazdirmak istersek:
        for (int i = 1; i <= qaConcortPage.satirlarListesi.size(); i++) {
            System.out.println(i + ". satir : " + qaConcortPage.satirlarListesi.get(i).getText());
        }

        // ○ 4.satirdaki(row) elementleri konsolda yazdırın. (satirlardaki 4. datalari getir):
        for (WebElement each : qaConcortPage.dorduncuStunListe) {
            System.out.println(each.getText());
        }

        Driver.closeDriver();

    }
}
