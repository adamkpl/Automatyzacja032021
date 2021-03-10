package Day2.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PromotedProduct {

    //opisz ten jeden element, ale wewntarz elementu
    //metoda add to cart
    //zwróc nazwe
    //popular - homefeatured
    //block bestsellers

//    public PromotedProduct(WebDriver driver) {
//        super(driver);
//    }

    WebDriver driver;

    @FindBy(css = ".product-container")
    private WebElement product_container;

    @FindBy(css = ".product-name")
    private WebElement product_container_title;

    @FindBy(css = "[itemprop=\"price\"]")
    private WebElement product_container_price;

    @FindBy(css = ".ajax_add_to_cart_button")
    private WebElement product_container_CTA_add_to_cart;

    public PromotedProduct addToCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(product_container_title);
        product_container_CTA_add_to_cart.click();
        return this;
    }



    //todo

    public double getPrice() {
        return Double.parseDouble(product_container_price.getText().replace("$",""));
    }

    public String getProductName() {
        return product_container_title.getText();
    }

    public PromotedProduct getProductContainerList() {
        //todo
        return this;
    }

}
