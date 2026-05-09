package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    By carticn = By.className("shopping_cart_link");
    By prdtnme = By.xpath("//div[text()='Sauce Labs Backpack']");

    By price = By.className("inventory_item_price");

    public void cartpage(){

        driver.findElement(carticn).click();
        String Name = driver.findElement(prdtnme).getText();
        String Prdtactname = "Sauce Labs Backpack";
       if(Name.equals(Prdtactname)) {
           System.out.println("Product name is " + Name);
       }else {
           System.out.println("Wrong Product has added to the Cart");
       }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(price));

            System.out.println("Price has been Displayed of the Product");
            String Value = driver.findElement(price).getText();
            System.out.println("Price of " + Name + " is " + Value);

        } catch (Exception e) {

            System.out.println("Price is not Displayed");
        }


    }



}
