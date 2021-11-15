package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class QAConcortPage {

    WebDriver driver;

    public QAConcortPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id = "UserName")
    public WebElement usernameKutusu;

    @FindBy(id = "Password")
    public WebElement passwordKutusu;

    @FindBy(id = "btnSubmit")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[text()='ListOfUsers']")
    public WebElement basariliGirisYaziElementi;

    @FindBy(xpath = "//*[.='Try again please']")
    public WebElement loginFailedYazisi;

    public void ConcortHotelLogin() {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQValidPassword"));
        qaConcortPage.loginButonu.click();
    }

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementLink;

    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelListLink;

    @FindBy(xpath = "//span[text()='Add Hotel ']")
    public WebElement addHotelLink;

    @FindBy(id = "Code")
    public WebElement addHotelCodeKutusu;

    @FindBy(className = "bootbox-body")
    public WebElement successfullyText;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement okButton;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsLink;

    @FindBy(xpath = "//span[text()='Add Hotelroom ']")
    public WebElement addHotelRoomButton;

    @FindBy(id = "IDHotel")
    public WebElement addRoomIdDropdown;

    @FindBy(id = "IDGroupRoomType")
    public WebElement addRoomType;

    @FindBy(id = "btnSubmit")
    public WebElement addRoomSaveButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement addRoomSuccsessfullText;

    @FindBy(xpath = "//div[@class='btn btn-primary']")
    public WebElement addRoomAllertOkButton;

    @FindBy(linkText = "Hotelrooms")
    public WebElement addRoomHotelRoomsLink;

    @FindBy(xpath = "//span[text()='List Of Hotelrooms']")
    public WebElement addRoomListOfHotelRoomsText;

    @FindBy(xpath = "//thead/tr[1]/th")
    public List<WebElement> basliklarListesi;

    @FindBy(xpath = "//tbody")
    public WebElement tbodyTumu;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;

    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement birinciSatir;

    @FindBy(xpath = "//tbody/tr//td[4]")            // //tbody//td[4]
    public List<WebElement> dorduncuSutunListe;

    public String printData(int satir, int sutun) {
        // String xpath = "//tbody//tr[3]//td[5]";
        // yukaridaki kodu dinamik hale getirelim:
        // (degismeyecek kisimlari String, degisecek kisimlari ise isim olarak yazdik)
        String xpath = "//tbody//tr[" + satir + "]//td[" + sutun + "]";

        // @FindBy notasyonu parametreli calismadigi icin onceki yontemle locate edelim:
        String istenenData = Driver.getDriver().findElement(By.xpath(xpath)).getText();
        System.out.println("satir no :" + satir + ", sutun no :" + sutun + " daki data :" + istenenData);

        return istenenData;
    }





}