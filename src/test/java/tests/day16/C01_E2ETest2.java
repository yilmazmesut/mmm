package tests.day16;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_E2ETest2 {

    @Test
    public void RoomCreateTest() throws InterruptedException {
        //3. https://qa-environment.concorthotel.com/ adresine gidin.
        // 4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        // a. Username : manager  b. Password  : Manager1!
        // 5. Login butonuna tıklayın.
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();

        // 6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        qaConcortPage.hotelManagementLink.click();
        qaConcortPage.hotelRoomsLink.click();
        qaConcortPage.addHotelRoomButton.click();

        // 7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Select select = new Select(qaConcortPage.addRoomIdDropdown);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAAddRoomIdHotel"));

        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("CHQAAddRoomIdDescription"))
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("CHQAAddRoomPrice"))
                .perform();

        select = new Select(qaConcortPage.addRoomType);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAAddRoomType"));

        actions.sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,2)))
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(0,5)))
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .click(qaConcortPage.addRoomSaveButton)
                .perform();

        // 8. Save butonuna basin.
        // 9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        Assert.assertTrue(qaConcortPage.addRoomSuccsessfullText.isDisplayed());

        //10. OK butonuna tıklayın.
        qaConcortPage.addRoomAllertOkButton.click();

        //11. Hotel rooms linkine tıklayın.
        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(3000);
        qaConcortPage.addRoomHotelRoomsLink.click();

        //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..
        Assert.assertTrue(qaConcortPage.addRoomListOfHotelRoomsText.isDisplayed());

        Driver.closeDriver();




    }
}
