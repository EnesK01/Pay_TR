package StepDefinitions;

import PagesObjectModels.CustomerApplyPage;
import PagesObjectModels.BasePage;
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
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
public class MyStepdefs {
    private static final Logger logger= LoggerFactory.getLogger(MyStepdefs.class);
    WebDriver driver;
    BasePage basePage;
    CustomerApplyPage customerApplyPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        basePage = new BasePage(driver);
        customerApplyPage = new CustomerApplyPage(driver);
    }

    @When("I open browser for and go to the Paytr production website for all scenarios")
    public void iNavigateToApplyPageAndApplyForAJob() {
        basePage.GoTomainPage();
    }

    @Then("Non-customer click the apply button")
    public void nonCustomerCanSeeTheApplyButtonIsPresentAtTheSite() {
        basePage.clickToBecomeNewCustomer();
    }

    @Then("Non-customer see the apply page")
    public void nonCustomerSeeTheApplyScreen() {

        logger.info("yeni taba gecildi");
        customerApplyPage.isDisplaying();
    }

    @Then("Non-customer fills name, surname,phone,gmail areas")
    public void nonCustomerFillsNameSurnamePhoneGmailAreas() {
        customerApplyPage.fillInformationsAboutThemself();

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
    @Then("Non-customer chooses the business type and left the other areas empty")
    public void nonCustomerChoosesTheBusinessTypeAndLeftTheOtherAreasEmpty() {
        customerApplyPage.chooseBusinessTypeandProduct();
        try {
            ıTakeScreenshotAndSaveAs("displaying_filled_fields");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Then("Non-customer accept the terms and apply")
    public void nonCustomerAcceptTheTermsAndApply() {
        customerApplyPage.acceptTermsAndSendApply();
    }
    @Then("Non-customer should see missing area warnings")
    public void nonCustomerShouldSeeMissingAreaWarnings() {
        customerApplyPage.SeeWarningMesssages();
    }
    @After()
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
