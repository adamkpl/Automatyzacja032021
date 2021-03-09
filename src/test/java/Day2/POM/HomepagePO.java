package Day2.POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomepagePO extends BasePO {

    Logger logger = Logger.getLogger(HomepagePO.class);

    public static final String URL_HOMEPAGE = "http://automationpractice.com/";

    @FindBy(css = ".logo")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(@title,'Women')]")
    private WebElement menuWomen;

    @FindBy(xpath = "//a[@title='Dresses'][1]")
    private WebElement menuWomenDisplayed;

    public HomepagePO(WebDriver driver) {
        super(driver);
    }

    public HomepagePO visitHomePage() {
        logger.trace("Open homepage");
        driver.get(URL_HOMEPAGE);
        return this;
    }

    public Boolean isDisplayed() {
        logger.trace("Should display " + logo);
        return logo.isDisplayed();
    }

    public HomepagePO hoverOverWomenMenu() {
        Actions actions = new Actions(driver);
        logger.trace("Move mouse cursor over Women menu item");
        actions.moveToElement(menuWomen).build().perform();
        return this;
    }

    public Boolean isWomenMenuDisplayed() {
        logger.trace("Should display " + menuWomenDisplayed);
        return menuWomenDisplayed.isDisplayed();
    }

}
