package tests.day17_Odevler;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;

public class W01_WebTables {

    @Test
    public void test() {
        //Bir class oluşturun : C02_WebTables
        //● login() metodun oluşturun ve oturum açın.
        //● https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        // ○ Username : manager
        // ○ Password : Manager1!

        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();

        // 1. pages sayfasinda bir metod oluşturun : printData(int row, int column);
        //   Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
        //  hücredeki(cell) veriyi yazdırmalıdır.

        //  2. Ve bu metodu printData() methodunu cagirmak icin kullanin.
        //     Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır

        String actualData = qaConcortPage.printData(3,5);

        //  3. yazdirilan datanin olmasi gereken dataya(USA) esit oldugunu test edin
        // Assert'i bu class'ta yapmak istiyorsak, istenen datanin bu class'a donmesini saglamaliyiz
        Assert.assertEquals(actualData, "USA", "actual data istenen dataya esit degil..");


    }
}
