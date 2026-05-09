package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;

    By title = By.className("title");
    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");

    public ProductPage(WebDriver driver){

        this.driver = driver;

    }

    public String getPageTitle(){

        return driver.findElement(title).getText();

    }

    public void addTocart(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(addToCartBtn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void openCart(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(cartIcon).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


}
