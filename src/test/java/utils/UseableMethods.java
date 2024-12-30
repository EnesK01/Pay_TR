package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class UseableMethods {
    protected WebDriver driver;

    public UseableMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public void element_presenceInseconds(WebElement element, int bekleme) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(bekleme));
        wait.until(ExpectedConditions.invisibilityOf(element));

    }

    //you can switch the last opened window with this function.
    public void switchtoLastWindow() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }
}
