package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_Raporlama extends TestBaseRapor {

    @Test
    public void test1() {
        // amazon sayfasina gidin
        // samsung icin arama yapin
        // sonuc sayisinin 1000 den az oldugunu test edelim
        // raporunu olusturalim:

        extentTest = extentReports.createTest("Nutella testi", "sonuc sayisi 1000 den az olmali");

        // amazon sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon sayfasina gidildi");

        // nutella icin arama yapin
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys(ConfigReader.getProperty("amazonArananKelime")+Keys.ENTER);
        extentTest.info("Nutella icin arama yapildi");

        // sonuc sayisinin 1000 den az oldugunu test edelim:
        String sonucYazisi = Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]")).getText();
              // 1-48 of 137 results for
        String sonucArrayi[] = sonucYazisi.split(" ");
        int sonucSayisi = Integer.parseInt(sonucArrayi[2]);
        extentTest.info("sonuc yazisi int haline getirildi");

        Assert.assertTrue(sonucSayisi < 1000, "Sonuc sayisi 1000'den kucuk degil");
        extentTest.pass("sonuc sayisinin 1000'den az oldugu test edildi");
    }


    @Test
    public void test2() {
        // amazon sayfasina gidin
        // samsung icin arama yapin
        // sonuc sayisinin 1000 den az oldugunu test edelim
        // raporunu olusturalim:

        extentTest = extentReports.createTest("samsung testi", "Sonuc sayisi 1000'den az olmali");

        // amazon sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon sayfasina gidilidi");

        // samsung icin arama yapin
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("samsung" + Keys.ENTER);
        extentTest.info("samsung icin arama yapildi");

        // sonuc sayisinin 1000 den az oldugunu test edelim:

        String sonucYazisi = Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]")).getText();
        String sonucArrayi[] = sonucYazisi.split(" ");

        String sonucAdedi = sonucArrayi[3];
        sonucAdedi = sonucAdedi.replace(",","");
        System.out.println(sonucAdedi);

        int sonucSayisi = Integer.parseInt(sonucAdedi);
        extentTest.info("sonuc yazisi int haline getirildi");

        Assert.assertTrue(sonucSayisi < 1000);
        extentTest.info("sonuc sayisinin 1000'den az oldugu test edildi");
    }

    @Test
    public void test3() {
        // amazon sayfasina gidin
        // electronic kategorisinde java icin arama yapin
        // cikan ilk sonucun isminde java oldugunu test edelim

        extentTest = extentReports.createTest("java testi", "ilk urunde java olmali");

        // amazon sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazona gidildi");

        // electronic kategorisinde java icin arama yapin
        Select select = new Select(Driver.getDriver().findElement(By.id("searchDropdownBox")));
        select.selectByVisibleText("Electronics");
        extentTest.info("dropdown'dan electronics secildi");

        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        extentTest.info("java kelimesi aratildi");

        // cikan ilk sonucun isminde java oldugunu test edelim
        String ilkElementYazisi = Driver.getDriver().findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]")).getText();

        Assert.assertTrue(ilkElementYazisi.contains("Java"));
        extentTest.info("ilk urun isminde java oldugu test edildi");
    }
}
