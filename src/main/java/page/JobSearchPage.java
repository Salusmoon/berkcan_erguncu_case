package page;

import driver.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class JobSearchPage extends TestMethod {

    protected static final Logger logger = Logger.getLogger(JobSearchPage.class.getName());
    WebDriver driver = BaseTest.driver ;

    WebElement areaFilterBox = driver.findElement(By.id("select2-filter-by-location-container"));
    WebElement pageCheck = waitUntilVisibleByLocater(driver, By.xpath("//span[@title=\"Quality Assurance\"]"),50);
    //WebElement locationIstanbul = driver.findElement(By.xpath("//li[contains(text(), 'Istanbul, Turkiye')]"));
    WebElement areaDepartmentBox = driver.findElement(By.id("select2-filter-by-department-container"));
    //WebElement departmentQA = driver.findElement(By.xpath("//li[contains(text(), 'Quality Assurance')]"));


    public void setLocation(){
        waitUntilVisible(driver,pageCheck,50);
        areaFilterBox.click();
        WebElement locationIstanbul = waitUntilVisibleByLocater(driver, By.xpath("//li[contains(text(), 'Istanbul, Turkiye')]"),10);
        locationIstanbul.click();
        logger.info("Location seted");
    }

    public void setDepartment(){
        areaDepartmentBox.click();
        WebElement departmentQA = waitUntilVisibleByLocater(driver, By.xpath("//li[contains(text(), 'Quality Assurance')]"),10);
        departmentQA.click();
        logger.info("Department seted");
    }

    public void checkJobList(){
        scroll(1,500);
        waitForTextToBe(driver,By.id("deneme"),"3",10);
        List<WebElement> listAllQaJobs = driver.findElements(By.className("position-list-item-wrapper"));
        for (WebElement jobElement : listAllQaJobs) {
            try {
                WebElement txtJobDepartment = jobElement.findElement(By.className("position-department"));
                String departmentText = txtJobDepartment.getText();
                if (!departmentText.equals("Quality Assurance")) {
                    throw new AssertionError("expected text 'Quality Assurance', but was: " + departmentText);
                }else{
                    logger.info("Job department : " + txtJobDepartment.getText());
                }
            } catch (NoSuchElementException e) {
                System.out.println("Department elementi not found.");
            }
            try {
                WebElement txtJobLocation = jobElement.findElement(By.className("position-location"));
                String locationText = txtJobLocation.getText();
                if (!locationText.equals("Istanbul, Turkiye")) {
                    throw new AssertionError("expected text 'Istanbul, Turkiye', but was: " + locationText);
                }else{
                    logger.info("Job Location : " + txtJobLocation.getText());
                }
            } catch (NoSuchElementException e) {
                System.out.println("Location element not found.");
            }
        }
        logger.info("All jobs check completed");
    }

    public void clickViewRole(){
        List<WebElement> listAllQaJobs = driver.findElements(By.className("position-list-item-wrapper"));
        WebElement lastJob = listAllQaJobs.get(listAllQaJobs.size() - 1);
        Actions actions = new Actions(driver);
        actions.moveToElement(lastJob).perform();
        List<WebElement> btnViewRole = driver.findElements(By.xpath("//a[contains(@class, 'btn-navy') and text()='View Role']"));
        btnViewRole.get(btnViewRole.size() - 1).click();
        logger.info("View role button clicked");
        waitByHand(5);
        switchToTab();
    }
}
