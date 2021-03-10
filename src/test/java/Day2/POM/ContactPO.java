package Day2.POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ContactPO extends BasePO {

    public ContactPO(WebDriver driver) {
        super(driver);
    }

    Logger logger = Logger.getLogger(ContactPO.class);

    // Form
    @FindBy(css = ".row")
    private WebElement contactForm;

    @FindBy(id = "id_contact")
    private WebElement subjectHeading;

    @FindBy(id = "uniform-id_contact")
    private WebElement subject;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "message")
    private WebElement message;

    @FindBy(id = "submitMessage")
    private WebElement sendMsgButton;

    @FindBy(className = "alert-success")
    private WebElement success;

    public boolean contactFormIsDisplayed() {
        logger.trace("contactFormIsDisplayed " + contactForm);
        return contactForm.isDisplayed();
    }

    public boolean subjectIsDisplayed() {
        logger.trace("subjectIsDisplayed " + subject);
        return subject.isDisplayed();
    }

    public boolean emailIsDisplayed() {
        logger.trace("emailIsDisplayed " + email);
        return email.isDisplayed();
    }

    public boolean messageIsDisplayed() {
        logger.trace("messageIsDisplayed " + message);
        return message.isDisplayed();
    }

    public boolean sendMsgButtonIsDisplayed() {
        logger.trace("sendMsgButtonIsDisplayed " + sendMsgButton);
        return sendMsgButton.isDisplayed();
    }

    public boolean successIsDisplayed() {
        logger.trace("successIsDisplayed " + success);
        wait.until(ExpectedConditions.visibilityOf(success));
        return success.isDisplayed();
    }

    public ContactPO selectHeading(String value) {
        logger.trace("selectHeading " + value);
        Select select = new Select(subjectHeading);
        select.selectByValue(value);
        return this;
    }

    public ContactPO typeEmailAddress(String emailAddress) {
        logger.trace("typeEmail " + emailAddress);
        email.sendKeys(emailAddress);
        return this;
    }

    public ContactPO typeMessage(String msg) {
        logger.trace("typeMessage " + msg);
        message.sendKeys(msg);
        return this;
    }

    public ContactPO sendMessage() {
        logger.trace("sendMessage");
        sendMsgButton.click();
        return this;
    }

}
