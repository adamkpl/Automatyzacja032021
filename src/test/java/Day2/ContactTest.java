package Day2;

import Day2.POM.ContactPO;
import Day2.POM.HomepagePO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest {

//    HomepagePO homepagePO = new HomepagePO(driver);
//    ContactPO contactPO = new ContactPO(driver);

    @Test
    public void verifyIfContactFormHasAllFieldsVisibleAndEnabledTest() {
        HomepagePO homepagePO = new HomepagePO(driver);
        ContactPO contactPO = new ContactPO(driver);
        //given
        homepagePO.visitHomePage().clickContactUs();
        //when
        contactPO.contactFormIsDisplayed();
        //then
        Assert.assertTrue(contactPO.sendMsgButtonIsDisplayed());
        Assert.assertTrue(contactPO.emailIsDisplayed());
        Assert.assertTrue(contactPO.messageIsDisplayed());
        Assert.assertTrue(contactPO.subjectIsDisplayed());
    }

    @Test
    public void sendMessageText() {
        HomepagePO homepagePO = new HomepagePO(driver);
        ContactPO contactPO = new ContactPO(driver);
        //given
        homepagePO.visitHomePage().clickContactUs();
        //when
        Assert.assertTrue(contactPO.contactFormIsDisplayed());
        Assert.assertTrue(contactPO.sendMsgButtonIsDisplayed());
        Assert.assertTrue(contactPO.subjectIsDisplayed());
        Assert.assertTrue(contactPO.emailIsDisplayed());
        Assert.assertTrue(contactPO.messageIsDisplayed());

        contactPO
                .selectHeading("2")
                .typeEmailAddress("noreply@noreply.pl")
                .typeMessage("MY TEST MESSAGE")
                .sendMessage();

        //then
        Assert.assertTrue(contactPO.successIsDisplayed());
    }

}
