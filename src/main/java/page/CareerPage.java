package page;

import driver.BaseTest;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareerPage extends TestMethod {

    protected static final Logger logger = Logger.getLogger(CareerPage.class.getName());
    WebDriver driver = BaseTest.driver ;


    WebElement logo = driver.findElement(By.xpath("//img[@alt='insider_logo']"));
    WebElement btnTeams = driver.findElement(By.className("loadmore"));
    WebElement txtTitleLocations = driver.findElement(By.className("ml-0"));
    WebElement txtTitleLife = driver.findElement(By.xpath("//h2[text()='Life at Insider']"));

    public void checkPageOpen(){
        waitByHand(2);
        Assert.assertTrue("Logo görüntülenemedi", logo.isDisplayed());
        logger.info("Logo loaded");
        scrollToElement(btnTeams);
        Assert.assertTrue("Teams butonu  görüntülenemedi", btnTeams.isDisplayed());
        logger.info("Button team displayed");
        waitByHand(2);
        scrollToElement(txtTitleLocations);
        Assert.assertTrue("Teams butonu  görüntülenemedi", txtTitleLocations.isDisplayed());
        logger.info("Location title displayed");
        waitByHand(2);
        scrollToElement(txtTitleLife);
        Assert.assertTrue("Teams butonu  görüntülenemedi", txtTitleLife.isDisplayed());
        logger.info("Life title displayed");
        logger.info("Careers page check completed");
        waitByHand(5);
    }

    public void goToQaDepartmant(){
        goToUrl("https://useinsider.com/careers/quality-assurance/");
        waitByHand(5);
    }

}
