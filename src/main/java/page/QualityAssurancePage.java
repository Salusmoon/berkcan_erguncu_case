package page;

import driver.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QualityAssurancePage extends TestMethod {

    protected static final Logger logger = Logger.getLogger(QualityAssurancePage.class.getName());
    WebDriver driver = BaseTest.driver ;

    WebElement btnSeeAllQAJobs = driver.findElement(By.linkText("See all QA jobs"));



    public void clickAllJobs(){
        waitUntilVisible(driver, btnSeeAllQAJobs,20);
        btnSeeAllQAJobs.click();
        logger.info("See all jobs button clicked");
    }
}
