package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C03_PozitiveTestConfigReaderIle extends TestBase {

    @Test
    public void positiveTestConfig() {
        // https://www.concorthotel.com/ adresine git
        driver.get(ConfigReader.getProperty("CHUrl"));
        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);

        //	login butonuna bas
        concortHotelPage.ilkLoginLinki.click();

        //	test data username: manager1 ,
        concortHotelPage.usernameKutusu.sendKeys("CHValidUsername");

        //	test data password : manager1!
        concortHotelPage.passwordKutusu.sendKeys("CHValidPassword");
        concortHotelPage.loginButonu.click();

        //	Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(concortHotelPage.basariliGirisYaziElementi.isDisplayed());

    }
}
