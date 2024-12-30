package PagesObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utils.UseableMethods;

public class BasePage {
    protected WebDriver driver;
   protected  UseableMethods useableMethods;
    String baseurl="https://www.paytr.com/";
    @FindBy(xpath = "(//div[@class='menu__button-container js-menu-buttons']/a)[2]")
    private WebElement applybutton;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.useableMethods = new UseableMethods(driver);
        PageFactory.initElements(driver, this);
    }
    public void GoTomainPage() {
        driver.get(baseurl);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(),baseurl);
    }
    public void clickToBecomeNewCustomer(){
    useableMethods.clickwithJS(applybutton);

    }
}
