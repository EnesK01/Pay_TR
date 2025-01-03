package PagesObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import utils.UseableMethods;

import java.util.List;

public class BasePage {
    protected WebDriver driver;
   protected  UseableMethods useableMethods;
    String baseurl="https://www.paytr.com/";
    String[] MainPageTitles={"Ödemeler İçin İhtiyacınız Olan Her Şey .","Ürünleri Mağaza Panelinizden Kolayca Yönetin","Geliştiriciler İçin","Neden Bizi Tercih Ediyorlar .","İş Ortakları ."};
    @FindBy(xpath = "(//div[@class='menu__button-container js-menu-buttons']/a)[2]")
    private WebElement applybutton;
    @FindBy(xpath = "//button[@class='button button-primary-light size:large accept-cookie-btn']")
    private WebElement acceptcookies;
    @FindBy(xpath = "//div[@class='payment-channel-head section-container flow-content']")
    private WebElement EverythingYouNeedTitle;
    @FindBy(xpath = "(//div[@class='custom-container'])[1]/div/div/div")
    private List<WebElement> EverythingYouNeedforPaymentstitles;
    @FindBy (xpath = "//h2[@class='section-title bold center']")
    private List<WebElement> five_Main_title;
    @FindBy (xpath = "(//*[contains(text(),'Ürünler')])[1]")
    private WebElement products_iconContainer;
    @FindBy(xpath = "(//div[@id='online-odeme-cozumleri']/a)[2]")
    private WebElement paymentViaLink;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.useableMethods = new UseableMethods(driver);
        PageFactory.initElements(driver, this);
    }
    public void ControlOf12Subheadings(){
       acceptcookies.click();
        if(EverythingYouNeedforPaymentstitles.get(0).isDisplayed()){
            SoftAssert softAssert=new SoftAssert();
            softAssert.assertEquals(EverythingYouNeedforPaymentstitles.size(),12);
        }


        useableMethods.untilSeeElement(EverythingYouNeedTitle);

    }
    public void ControlOf5Subheadings(){
        SoftAssert softAssert=new SoftAssert();
        if(five_Main_title.get(0).isDisplayed()){

            softAssert.assertEquals(five_Main_title.size(),5);

        }
       for(int i=0;i<five_Main_title.size();i++){
           softAssert.assertEquals(five_Main_title.get(i).getText(),MainPageTitles[i]);
       }

    }
    public void GoTomainPage() {
        driver.get(baseurl);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(),baseurl);
        softAssert.assertAll();
    }
    public void moveToProductandChoosepaymentViaLink(){
    useableMethods.moveToelement(products_iconContainer);
    paymentViaLink.click();

    }
}
