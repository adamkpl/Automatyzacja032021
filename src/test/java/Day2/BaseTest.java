package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected WebDriver driver;
    Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeClass
    public void setupClass() {
        DOMConfigurator.configure("log4j.xml");
        //WebDriverWait wait = new WebDriverWait(driver, 10);
    }

    @BeforeMethod
    public void setup() {
        logger.info("Create browser instance");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void teardown() {
        logger.trace("Trying to kill browser instance");
        // Kill driver
        driver.close(); // closes a window
        driver.quit(); // kills a driver instance
        logger.info("Browser instance killed.");
    }

}
