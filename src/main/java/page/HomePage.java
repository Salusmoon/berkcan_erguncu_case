package page;


import driver.BaseTest;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends TestMethod {

    protected static final Logger logger = Logger.getLogger(HomePage.class.getName());
    WebDriver driver = BaseTest.driver ;

    //WebElement btnPopUpClose = driver.findElement(By.className("ins-close-button"));
    WebElement btnCookiesAccept = driver.findElement(By.id("wt-cli-accept-all-btn"));
    WebElement logo = driver.findElement(By.xpath("//img[@alt='insider_logo']"));
    List<WebElement> txtMenu = driver.findElements(By.id("navbarDropdownMenuLink"));
    WebElement elemCompanySubMidCont = driver.findElement(By.className("new-menu-dropdown-layout-6-mid-container"));
    List<WebElement> elemCompanySubMidMenus = elemCompanySubMidCont.findElements(By.className("dropdown-sub"));


    public void acceptCookies(){
        waitByHand(2);
        btnCookiesAccept.click();
        logger.info("Cookies accepted");
    }

    public void checkPageOpen(){
        waitByHand(2);
        Assert.assertTrue("Logo görüntülenemedi!",logo.isDisplayed());
        logger.info("Logo loaded");
        Assert.assertTrue("Why Insider  görüntülenemedi", txtMenu.get(0).isDisplayed());
        Assert.assertTrue("Platfrom  görüntülenemedi", txtMenu.get(0).isDisplayed());
        Assert.assertTrue("Solutions  görüntülenemedi", txtMenu.get(0).isDisplayed());
        Assert.assertTrue("Resource  görüntülenemedi", txtMenu.get(0).isDisplayed());
        Assert.assertTrue("Company  görüntülenemedi", txtMenu.get(0).isDisplayed());
        logger.info("Menus loaded");
        logger.info("Home page check completed");
    }

    public void clickCareersMenu(){
        txtMenu.get(4).click();
        elemCompanySubMidMenus.get(1).click();
        logger.info("Career menu clicked");
    }


}
