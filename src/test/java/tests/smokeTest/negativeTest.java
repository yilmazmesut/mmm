package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class negativeTest {

    //1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
    //3 Farkli test Methodunda 3 senaryoyu test et
    // - yanlisSifre
    // - yanlisKulllanici
    // - yanlisSifreKullanici

    //test data yanlis username: manager1 , yanlis password : manager1
    //2) https://qa-environment.concorthotel.com/ adresine git
    //3) Login butonuna bas
    //4) Verilen senaryolar ile giris yapilamadigini test et

    @Test(priority = -5)
    public void yanlisSifre() {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQInvalidPassword"));
        qaConcortPage.loginButonu.click();
        Assert.assertTrue(qaConcortPage.loginFailedYazisi.isDisplayed());
    }

    @Test(dependsOnMethods = "yanlisSifre")
    public void yanlisKullanici() {
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.usernameKutusu.clear();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQInvalidUsername"));
        qaConcortPage.passwordKutusu.clear();
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQValidPassword"));
        qaConcortPage.loginButonu.click();
        Assert.assertTrue(qaConcortPage.loginFailedYazisi.isDisplayed());
    }

    @Test   // Buna priority atamadik, zaten default olarak 0 kabul ediyor.
    public void yanlisSifreKullanici() {
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.usernameKutusu.clear();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQInvalidUsername"));
        qaConcortPage.passwordKutusu.clear();
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQInvalidPassword"));
        qaConcortPage.loginButonu.click();
        Assert.assertTrue(qaConcortPage.loginFailedYazisi.isDisplayed());
        Driver.closeDriver();
    }

}
