package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class positiveLoginTest {

    @Test
    public void positiveLoginTest(){
        //Bir test method olustur positiveLoginTest()
        // https://qa-environment.concorthotel.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        // login butonuna bas
        qaConcortPage.ilkLoginLinki.click();

        //test data username: manager ,
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQValidUsername"));

        //test data password : Manager1!
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQValidPassword"));

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(qaConcortPage.basariliGirisYaziElementi.isDisplayed());

    }
}
