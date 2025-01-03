package PagesObjectModels;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;


public class ApplyPaymentViaLinkPage extends BasePage {

    private static final Logger logger= LoggerFactory.getLogger(BasePage.class);
    public ApplyPaymentViaLinkPage(WebDriver driver) {
        super(driver);
    }
    protected String PaymentViaLinkPageUrl="https://www.paytr.com/linkle-odeme";
    @FindBy(xpath = "//input[@id='first-name']")
    private  WebElement authorized_name;
    @FindBy(name = "surname")
    private  WebElement authorized_surname;
    @FindBy(id = "email")
    private  WebElement mail_address;
    @FindBy(name = "tel")
    private  WebElement phone_number;
    @FindBy(name = "website")
    private  WebElement Website;
    @FindBy(xpath = "//div[@class='select-selected']")
    private WebElement business_type_selectbox;
    @FindBy(xpath = "(//div[@class='select-items']/div)[3]")
    private WebElement limited_company;
    @FindBy(xpath = "//input[@name='agreementInd']")
    private WebElement accept_process_of_personal_Data;
    @FindBy(xpath = "//button[@class='button button-primary-light size:large']")
    private WebElement send_apply;
    public void isDisplaying() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
      if( wait.until(ExpectedConditions.elementToBeClickable(authorized_name)).isDisplayed()){
          logger.info("basvuru sayfasi yuklendi");
          Assert.assertEquals(driver.getCurrentUrl(),PaymentViaLinkPageUrl);

      };


    }
    public void takeInformationsAboutCompanyandChooseBusinessForAreaFirstType() throws IOException {
        String datasPath="C:\\Users\\EXCALIBUR\\IdeaProjects\\Pay_TR\\src\\test\\resources\\UserInformations\\Informations.xlsx";
        FileInputStream file=new FileInputStream(datasPath);
        Workbook CompanyInformations= WorkbookFactory.create(file);
        Sheet sheet=CompanyInformations.getSheetAt(0);
        Row row= sheet.getRow(1);
        int a=row.getLastCellNum()+1;
        for(int i=0;i<a;i++){
            Cell cell=row.getCell(i);
            if(i == 0){
            useableMethods.sendkeys(authorized_name,cell.toString());
            }
            else if(i==1){
                useableMethods.sendkeys(authorized_surname,cell.toString());
            }
            else if(i==2){
                useableMethods.sendkeys(mail_address,cell.toString());
            }
            else if(i==3){
                useableMethods.sendkeys(Website,cell.toString());
            }
            else if(i==4){
                 try {
                     useableMethods.sendkeys(phone_number, cell.toString());
                 }catch (Exception e){

                 }
            }

        }
        CompanyInformations.close();
        file.close();
        business_type_selectbox.click();
        useableMethods.clickwithJS(limited_company);

    }
    public void sendApplyprocess(){
        useableMethods.clickwithJS(accept_process_of_personal_Data);
        send_apply.click();
    }

}
