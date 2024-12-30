package PagesObjectModels;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;;

public class CustomerApplyPage extends BasePage {

    private static final Logger logger= LoggerFactory.getLogger(BasePage.class);
    public CustomerApplyPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='name']")
    private  WebElement authorized_name;
    @FindBy(xpath = "//input[@id='surname']")
    private  WebElement authorized_surname;
    @FindBy(id = "email")
    private  WebElement mail_address;
    @FindBy(id = "phone")
    private  WebElement phone_number;
    @FindBy(xpath = "//*[contains(text(),'Başvurulacak Ürün')]")
    private  WebElement businessType_selectbox;
    @FindBy(xpath = "(//input[@type='checkbox'])")
    private  List<WebElement> businessType_selectbox_choices;
    @FindBy(xpath = "(//*[substring(normalize-space(text()), string-length(normalize-space(text())) - string-length('gerekli alan.') + 1) = 'gerekli alan.'])[0]")
    private WebElement areaRequiredMessage;
    @FindBy(id = "agreementInd")
    private WebElement acceptTerms;
    @FindBy(xpath = "//button[@class='style_button__dHHoa']")
    private WebElement send_apply;
    public void isDisplaying() {
        useableMethods.switchtoLastWindow();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
      if( wait.until(ExpectedConditions.elementToBeClickable(authorized_name)).isDisplayed()){
          logger.info("basvuru sayfasi yuklendi");

      };


    }
    public void fillInformationsAboutThemself(){
        useableMethods.sendkeys(authorized_name,"Manuel");
        useableMethods.sendkeys(authorized_surname,"Tester");
        useableMethods.sendkeys(mail_address,"oto@gmail.com");
        useableMethods.sendkeys(phone_number,"05229876655");

    }
    public void chooseBusinessTypeandProduct(){
        useableMethods.scrolldownAtPage();
        businessType_selectbox.click();
//sanal pos ürünü secildi.
       useableMethods.clickwithJS(businessType_selectbox_choices.get(0));
       //acilan selectboxi kapatmak için
     useableMethods.clickwithActions(businessType_selectbox);

    }
    public void acceptTermsAndSendApply(){
        useableMethods.scrolldownAtPage();
        acceptTerms.click();
        useableMethods.scrolldownAtPage();
        send_apply.click();
    }
    public void SeeWarningMesssages(){
        useableMethods.element_presenceInseconds(areaRequiredMessage,20);
    }
}
