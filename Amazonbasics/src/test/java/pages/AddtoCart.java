package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonWait;

import java.time.Duration;
import java.util.Set;

public class AddtoCart extends Product {

    //Since extended the Calls, no need to redeclare WebDriver driver again in child class


    public AddtoCart(WebDriver driver){
        super(driver); // call parent constructor

    }

    By addtocartbtn = By.xpath("//div[@id='desktop_qualifiedBuyBox']//div[@id='addToCart_feature_div' and @data-csa-c-is-in-initial-active-row='true']//input[@id='add-to-cart-button']");
    By cartcount = By.xpath("//span[@id='nav-cart-count']");

    public void cartverifction(){

        String beforecart = driver.findElement(cartcount).getText();
        System.out.println("Count Before Cart is " + beforecart);
        CommonWait.pause(10);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement button = wait1.until(ExpectedConditions.elementToBeClickable(addtocartbtn));



        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", button);

        button.click();

        CommonWait.pause(10);
        String aftercart = driver.findElement(cartcount).getText();
        int beforecartint = Integer.parseInt(beforecart);
        int aftercartint = Integer.parseInt(aftercart);
        System.out.println("Count after Cart is : " + aftercart);


        if(aftercartint>beforecartint) {
            System.out.println("The Item has successfully added to the Cart");

        }else {

            System.out.println("Item failed to add to the Cart");
        }




    }





}
