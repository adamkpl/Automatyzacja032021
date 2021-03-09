package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");  // Must be for Jenkins!
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void teardown() {
        // Kill driver
        driver.close(); // closes a window
        driver.quit(); // kills an driver instance
    }

    @Test
    public void browserIsStartedTest() throws InterruptedException {
        // Go to
        driver.get("http://automationpractice.com/"); // When 'loading indicator' stops

        // Find Contact
        driver.findElement(By.id("contact-link")).click();

        // Map Form WebElements
        WebElement send_msg_button = driver.findElement(By.id("submitMessage"));
        Assert.assertTrue(send_msg_button.isDisplayed());
        Select subject = new Select(driver.findElement(By.id("id_contact")));
        WebElement email = driver.findElement(By.id("email"));
        WebElement msg = driver.findElement(By.id("message"));

        // Fill out contact form
        subject.selectByValue("2");
        email.sendKeys("a@a.pl");
        msg.sendKeys("hello");

        // Send msg
        send_msg_button.click();

        // Assert if sent
        Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=contact");
        WebElement success = driver.findElement(By.xpath("//*[@class='alert alert-success']"));
        //WebElement success = driver.findElement(By.cssSelector(".alert-success"));
        Assert.assertTrue(success.isDisplayed());

        // Optional wait for a human eye
        Thread.sleep(1500);

    }

    @Test
    public void secondTest() {
        driver.get("https://swiatroweru.com.pl/warsztat/seminariumStronka/");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // klik4 button sekcja 4
        WebElement klik4 = driver.findElement(By.cssSelector("[data-section]+section button"));
        wait.until(ExpectedConditions.elementToBeClickable(klik4));
        klik4.click();

        // Assert img visible
        WebElement img = driver.findElement(By.tagName("img"));
        wait.until(ExpectedConditions.visibilityOf(img));
        Assert.assertTrue(img.isDisplayed());
    }

    @Test
    public void alertsTest() {
        driver.get("https://swiatroweru.com.pl/warsztat/seminariumStronka/");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement klik3 = driver.findElement(By.cssSelector("[data-section] button"));
        wait.until(ExpectedConditions.elementToBeClickable(klik3));
        klik3.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        //WebElement confirmationText = driver.findElement(By.xpath("//*[@data-section='section3'][contains(.,'Dziwny wiersz dodawany dynamicznie')]"));
        WebElement confirmationText = driver.findElement(By.cssSelector(".row"));
        wait.until(ExpectedConditions.visibilityOf(confirmationText));
        Assert.assertTrue(confirmationText.isDisplayed());
    }


    @Test
    public void dragAndDropTest() {
        //given
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.cssSelector("[data-id=\"2\"]"));
        WebElement destination = driver.findElement(By.id("amt7"));

        //when
        actions.dragAndDrop(source, destination).build().perform();

        //then
        WebElement expected = driver.findElement(By.cssSelector("#amt7>[data-id=\"2\"]"));
        Assert.assertTrue(expected.isDisplayed());
    }




}
