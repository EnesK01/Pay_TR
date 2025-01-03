package StepDefinitions;

import PagesObjectModels.ApplyPaymentViaLinkPage;
import PagesObjectModels.BasePage;
import PagesObjectModels.BecomeABusinessCustomerPage;
import PagesObjectModels.SuccessFullyAppliedPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.UseableMethods;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
public class MyStepdefs {
    private static final Logger logger= LoggerFactory.getLogger(MyStepdefs.class);
    WebDriver driver;
    BasePage basePage;
    ApplyPaymentViaLinkPage applyPaymentViaLinkPage;
    BecomeABusinessCustomerPage becomeABusinessCustomerPage;
    UseableMethods useableMethods;
    SuccessFullyAppliedPage successFullyAppliedPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        basePage = new BasePage(driver);
        applyPaymentViaLinkPage = new ApplyPaymentViaLinkPage(driver);
        becomeABusinessCustomerPage=new BecomeABusinessCustomerPage(driver);
        useableMethods=new UseableMethods(driver);
        successFullyAppliedPage=new SuccessFullyAppliedPage(driver);
    }
    @When("I open browser for and go to the Paytr production website loaded successfully for all scenarios")
    public void iNavigateToApplyPageAndApplyForAJob(){
        basePage.GoTomainPage();
        useableMethods.PageLoadedSuccessFully();

    }
    @Then("Control of 12 subheadings of the Everything You Need for Payments heading")
    public void thenICheckWeCanSeeTwelveTitleAtTheHomepage() {
        basePage.ControlOf12Subheadings();
    }
    @Then("Control of 5 subheadings of the Mainpage")
    public void controlOfSubheadingsOfTheMainpage() {
        basePage.ControlOf5Subheadings();

    }

    @Then("I take screenshot and save as {string}")
    public void ıTakeScreenshotAndSaveAs(String arg0) throws IOException {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File screenShot=ts.getScreenshotAs(OutputType.FILE);
        String abspath= Paths.get("src\\test\\resources\\screenshots").toAbsolutePath().toString();
        String filename=arg0+"-"+System.currentTimeMillis()+".png";
        String path=abspath+"\\"+filename;
        FileUtils.copyFile(screenShot,new File(path));

    }
    @Then("I see product option and choose the payment type")
    public void ıSeeProductOptionAndHover() {
        basePage.moveToProductandChoosepaymentViaLink();
    }
    @Then("I check the payment via link page loaded successfully")
    public void ıCheckThePaymentViaLinkPageLoadedSuccessfully() {
        applyPaymentViaLinkPage.isDisplaying();
    }
    @Then("I fill main first informations areas about company and choose businesstype")
    public void ıFillFirstMainInformationsAboutCompany() throws IOException {
            applyPaymentViaLinkPage.takeInformationsAboutCompanyandChooseBusinessForAreaFirstType();

    }
    @Then("I accept the terms and send apply")
    public void ıAcceptTheTermsAndSendApply() {
        applyPaymentViaLinkPage.sendApplyprocess();
    }
    @Then("I fill main second informations areas about company and choose businesstype")
    public void ıFillMainSecondInformationsAreasAboutCompanyAndChooseBusinesstype() throws IOException, InterruptedException {
        becomeABusinessCustomerPage.takeInformationsAboutCompanyandChooseBusinessForAreaSecondType();

    }
    @Then("I send apply for last time")
    public void ıSendApplyToTakeReferenceNumber() throws InterruptedException {
        becomeABusinessCustomerPage.sendApplyAndSaveReferenceNumber();
    }
    @Then("I see successfully apply and save the reference number")
    public void ıSeeSuccessfullyApplyAndSaveTheReferenceNumber() throws InterruptedException, IOException {
        successFullyAppliedPage.seeSuccessAndSaveReferenceNumber();

    }
    @After()
    public void tearDown() {
        if (driver != null) {
            driver.quit();

        }
    }



}
