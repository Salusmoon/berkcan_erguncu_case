package page;

import driver.BaseTest;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobPage extends TestMethod {

    protected static final Logger logger = Logger.getLogger(JobPage.class.getName());
    WebDriver driver = BaseTest.driver ;


    WebElement jobTxtTitle = driver.findElement(By.xpath("//h2[text()='Software Quality Assurance Engineer']"));
    WebElement jobTxtLocatian = driver.findElement(By.xpath("//div[text()='Istanbul, Turkiye']"));
    WebElement jobTxtRole = driver.findElement(By.xpath("//div[text()='Quality Assurance /']"));
    WebElement jobTxtCommitment = driver.findElement(By.xpath("//div[text()='Full-Time (Remote) /']"));
    WebElement jobTxtWorkPlaceTypes = driver.findElement(By.xpath("//div[text()='Remote']"));



    public void checkJobPage(){
        Assert.assertEquals("Job title text not correct","Software Quality Assurance Engineer", jobTxtTitle.getText());
        logger.info("Job title text correct");
        Assert.assertEquals("Job Location text not correct","Istanbul, Turkiye", jobTxtLocatian.getText());
        logger.info("Job Location  text correct");
        Assert.assertEquals("Job Role text not correct","Quality Assurance /", jobTxtRole.getText());
        logger.info("Job Role text correct");
        Assert.assertEquals("Job Commitment text not correct","Full-Time (Remote) /", jobTxtCommitment.getText());
        logger.info("Job Commitment text correct");
        Assert.assertEquals("Job Work Place text not correct","Remote", jobTxtWorkPlaceTypes.getText());
        logger.info("Job Work Place  correct");
        logger.info("Job page check completed");

    }
}
