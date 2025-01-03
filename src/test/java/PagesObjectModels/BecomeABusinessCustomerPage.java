package PagesObjectModels;

import org.apache.poi.ss.usermodel.*;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;

public class BecomeABusinessCustomerPage extends BasePage{
    private static final Logger logger= LoggerFactory.getLogger(BasePage.class);
    String baseUrl="https://www.paytr.com/uye-isyeri-olun";
    @FindBy(name = "company_title")
    private WebElement Company_reputation;
    @FindBy(id = "tax_no")
    private  WebElement tax_no;
    @FindBy(id = "tax_office")
    private  WebElement tax_office;
    @FindBy(id = "monthly_sale")
    private  WebElement monthly_sale;
    @FindBy (xpath = "//button[@class='style_button__dHHoa']")
    private WebElement send_apply;
    @FindBy (xpath = "//*[contains(text(),'Teşekkürler, ön başvurunuz tarafımıza ulaşmıştır.')]")

    private WebElement successfully_message;
    public BecomeABusinessCustomerPage(WebDriver driver) {
        super(driver);
    }

    public void takeInformationsAboutCompanyandChooseBusinessForAreaSecondType() throws IOException, InterruptedException {
        Thread.sleep(3000);
        String datasPath="C:\\Users\\EXCALIBUR\\IdeaProjects\\Pay_TR\\src\\test\\resources\\UserInformations\\Informations.xlsx";
        FileInputStream file=new FileInputStream(datasPath);
        Workbook CompanyInformations= WorkbookFactory.create(file);
        Sheet sheet=CompanyInformations.getSheetAt(0);
        Row row= sheet.getRow(1);
        int a=row.getLastCellNum()+1;
        for(int i=5;i<a;i++){
            Cell cell=row.getCell(i);
            if(i == 5){
                useableMethods.sendkeys(Company_reputation,cell.toString());

            }
            else if(i==6){
                useableMethods.sendkeys(tax_no,cell.toString());
            }
            else if(i==7){
                useableMethods.sendkeys(tax_office,cell.toString());
            }
            else if(i==8){
                useableMethods.sendkeys(monthly_sale,cell.toString());
            }
            else{
                System.out.println("ikinci asama bitti");
            }
        }
        CompanyInformations.close();
      file.close();
    }
    public void sendApplyAndSaveReferenceNumber() throws InterruptedException {
        useableMethods.untilSeeElement(send_apply);
       useableMethods.clickwithJS(send_apply);

    }
}
