package driver;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.ConfigReader;


public class BaseTest {

    public static WebDriver driver;

    ConfigReader configReader;

    public BaseTest(){
        configReader = new ConfigReader();
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notification");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.setAcceptInsecureCerts(true);
        return chromeOptions;
    }


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", configReader.getFilePath("chromeDriver"));
        driver = new ChromeDriver(getChromeOptions());
        driver.get("https://useinsider.com/");
        driver.manage().window().maximize();
    }

    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }




}
