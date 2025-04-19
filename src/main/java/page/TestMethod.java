package page;

import driver.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class TestMethod extends BaseTest{

    protected static final Logger logger = Logger.getLogger(TestMethod.class.getName());


    protected void goToUrl(String url){
        driver.get(url);
        waitByHand(5);
        logger.info("went to the address : " +url);
    }

    protected void waitByHand(int seconds){
        try{
            Thread.sleep(seconds* 1000L);

        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }

    protected void scrollToElement(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int maxScroll = 10;
        int i = 0;

        while (i < maxScroll) {
            try {
                if (webElement.isDisplayed()) {
                    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", webElement);
                    logger.info("Element founded and scrolled");
                    return;
                }
            } catch (NoSuchElementException e) {
                js.executeScript("window.scrollBy(0, 100);");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {}
            }
            i++;
        }

    }

    protected WebElement waitUntilVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitUntilVisibleByLocater(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void scroll(int maxScroll, int scrollStep){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(int i =0 ; i<maxScroll; i++){
            js.executeScript("window.scrollBy(0, arguments[0]);", scrollStep);
            logger.info("scrolled");
            waitByHand(1);
        }
    }

    protected void switchToTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1));
        } else {
            System.out.println("A second tab was not found");
        }
    }

    protected static void waitForTextToBe(WebDriver driver, By locator, String expectedText, int maxAttemptsInSeconds) {
        int attempt = 0;
        while (true) {
            WebElement element = driver.findElement(locator);
            String currentText = element.getText();
            if (currentText.equals(expectedText)) {
                logger.info("Value is '" + expectedText + " search stopped");
                break;
            }
            attempt++;
            if (attempt >= maxAttemptsInSeconds) {
                logger.info("Timeout. Value is not'" + expectedText);
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
