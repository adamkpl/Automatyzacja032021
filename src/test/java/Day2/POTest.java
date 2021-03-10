package Day2;

import Day2.POM.HomepagePO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POTest extends BaseTest {

    @Test
    public void logoIsDisplayed() {
        //given
        HomepagePO homepagePO = new HomepagePO(driver);
        //when
        homepagePO.visitHomePage();
        //then
        Assert.assertTrue(homepagePO.isDisplayed());
    }

    @Test
    public void menuIsDisplayedAfterHover() {
        //given
        HomepagePO homepagePO = new HomepagePO(driver);
        //when
        boolean actual = homepagePO
                .visitHomePage()
                .hoverOverWomenMenu()
                .isWomenMenuDisplayed();
        //then
        Assert.assertTrue(actual);
    }

//    @Test
//    public void addProductToCartTest() {
//        //given
//        HomepagePO homepagePO = new HomepagePO(driver);
//        //when
//
//
//        //then
//        Assert.assertTrue(actual);
//    }



}
