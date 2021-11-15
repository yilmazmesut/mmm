package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_ReusableMethodsKullanimi {

    // Uzun yoldan yapalim
    @Test
    public void test() {
        // https://the-internet.herokuapp.com/windows adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        // ilk sayfanin handle degerini alalim:
        String ilkSayfaHandleDegeri = Driver.getDriver().getWindowHandle();

        // click here yazisina basalim
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        // tum handle lari set e dolduralim:
        Set<String> windowHandleKumesi = Driver.getDriver().getWindowHandles();

        String ikinciSayfaHandleDegeri="";
        for (String each : windowHandleKumesi) {
            if (!each.equals(ilkSayfaHandleDegeri)) {
                ikinciSayfaHandleDegeri=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandleDegeri);
        System.out.println("Ikinci sayfanin Handle degeri : "+Driver.getDriver().getTitle());

        // yeni sayfada New Window yazisinin ciktigini test edin
        WebElement newWindowYaziElementi = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindowYaziElementi.isDisplayed());

        Driver.closeDriver();
    }

    // Reusable method ile cozumu:
    @Test
    public void testReusableIle() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethods.switchToWindow("New Window");
        WebElement newWindowYaziElementi = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindowYaziElementi.isDisplayed());
        ReusableMethods.waitFor(3);
        Driver.closeDriver();


    }
}
