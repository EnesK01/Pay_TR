package utils;

import PagesObjectModels.BasePage;
import com.beust.ah.A;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UseableMethods {
    protected WebDriver driver;
    private static final Logger logger= LoggerFactory.getLogger(UseableMethods.class);
    public UseableMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void PageLoadedSuccessFully(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while (!js.executeScript("return document.readyState").equals("complete")) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        logger.info("sayfa basariyla yüklendi");

    }
    //if the "Click" is not enough, use this function
    public void clickwithJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
    //if the "Click" is not enough, use this function
    public void clickwithActions(WebElement element) {
        new Actions(driver).moveToElement(element).click().build().perform();
    }

    public void sendkeys(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void scrolldownAtPage() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,250)", "");
    }

    public void element_presenceInseconds(WebElement element) throws InterruptedException {
        int i=0;
        if(!element.isDisplayed() && i<5){
            Thread.sleep(2000);
            i++;
        }

    }

    //you can switch the last opened window with this function.
    public void switchtoLastWindow() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public void untilSeeElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        while (true) {
            executor.executeScript("window.scrollBy(0,250);");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Kaydırma işlemi sonrası yeni yüklenen içerik var mı kontrol et
            boolean isElementVisible = element.isDisplayed();

            if (isElementVisible) {
                break;
            }
        }
    }
    public void moveToelement(WebElement element){
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();
    }
    public String extractReferenceNumber(String text) {
        String prefix = "Referans no: ";
        return text.startsWith(prefix) ? text.substring(prefix.length()).trim() : "";
    }
    }

