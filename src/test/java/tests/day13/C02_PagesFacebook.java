package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {

    // facebook sayfasina gidin
    // kullanici adi: techproed
    // sifre : 12345
    // yazdiginizda giris yapamadigimizi test edin
    // page sayfasinda cookiesGec() methodu olusturalim


    @Test
    public void test() {
        driver.get("https://wwww.facebook.com");
        FacebookPage facebookPage = new FacebookPage(driver);
        facebookPage.cookiesGec();
        facebookPage.mailKutusu.sendKeys("techproed@hotmail.com");
        facebookPage.sifreKutusu.sendKeys("12345");
        facebookPage.loginTusu.click();
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());
    }










}
