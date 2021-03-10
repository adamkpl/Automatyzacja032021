package Steps;

import Day2.POM.ContactPO;
import Day2.POM.HomepagePO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Steps {
    private Logger logger = Logger.getLogger(Steps.class);
    private static WebDriver driver;
    private HomepagePO homepagePO;
    private ContactPO contactPO;

    @Before
    public static void setup() {
        DOMConfigurator.configure("log4j.xml");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public static void teardown() {
        driver.quit();
    }

    @Given("homepage is opened")
    public void homepage_is_opened() {
        homepagePO = new HomepagePO(driver);
        homepagePO.visitHomePage();
    }

    @When("I click Contact link")
    public void i_click_contact_link() {
        homepagePO.clickContactUs();
    }

    @Then("Contact Us page is opened")
    public void contact_us_page_is_opened() {
        contactPO = new ContactPO(driver);
        Assert.assertTrue(contactPO.contactFormIsDisplayed());
        Assert.assertTrue(contactPO.sendMsgButtonIsDisplayed());
    }

    @Then("{string} is displayed")
    public void is_displayed(String string) {
        //
    }

}
