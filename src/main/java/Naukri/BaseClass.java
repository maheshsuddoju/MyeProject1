package Naukri;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class BaseClass  {

    public static WebDriver driver;

    public void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

    }

    public void getUrl(String url) {
        driver.get(url);
    }

    public static void waitAndClick(String locator) {
        WebElement webElement = driver.findElement(By.xpath(locator));
        if (explicitWait(webElement)) {
            webElement.click();
        }


    }
    public static void waitAndScrollToElement(String locator) {
        WebElement webElement = driver.findElement(By.xpath(locator));
        if (explicitWait(webElement)) {
            Actions actions = new Actions(driver);
            actions.scrollToElement(webElement);
        }


    }


    public static void waitAndSendText(String locator, String text) {
        WebElement webElement = driver.findElement(By.xpath(locator));
        if (explicitWait(webElement)) {
            webElement.sendKeys(text);
        }
    }

    public static String waitAndGetText(String locator) {
        WebElement webElement = driver.findElement(By.xpath(locator));
        if (explicitWait(webElement)) {
            return webElement.getText();
        }
        return "unable to get text";
    }

    public static boolean explicitWait(WebElement webElement) {

        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(2))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
           return webElement.isDisplayed();

        } catch (TimeoutException e) {
            System.out.println(
                    "Timed out waiting for element to be clickable..");
        }
        return false;
    }



    public void tearDown() {
        driver.close();
    }
}
