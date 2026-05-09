package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import java.time.Duration;

public class Payment {

    WebDriver driver;

    By cart = By.id("cartur");
    By placeord = By.xpath("//button[text()='Place Order']");
    By name = By.xpath("//form//label[@id='totalm']/following::input[@id=\"name\"]");
    By country = By.xpath("//form//label[@id='totalm']/following::input[@id=\"country\"]");
    By city = By.xpath("//form//label[@id='totalm']/following::input[@id=\"city\"]");
    By card = By.xpath("//form//label[@id='totalm']/following::input[@id=\"card\"]");
    By month = By.xpath("//form//label[@id='totalm']/following::input[@id=\"month\"]");
    By year = By.xpath("//form//label[@id='totalm']/following::input[@id=\"year\"]");
    By purchase = By.xpath("//button[text()=\"Purchase\"]");
    By okbtn = By.xpath("//button[text()='OK']");

    public Payment(WebDriver driver){

        this.driver = driver;

    }

    public void payment(String Name,String Country,String City, String Card, String Month, String Year){

        driver.findElement(cart).click();
        CommonUtils.pause(5);
        driver.findElement(placeord).click();
        CommonUtils.pause(5);
        driver.findElement(name).sendKeys(Name);
        CommonUtils.pause(5);
        driver.findElement(country).sendKeys(Country);
        CommonUtils.pause(5);
        driver.findElement(city).sendKeys(City);
        CommonUtils.pause(5);
        driver.findElement(card).sendKeys(Card);
        CommonUtils.pause(5);
        driver.findElement(month).sendKeys(Month);
        CommonUtils.pause(5);
        driver.findElement(year).sendKeys(Year);
        CommonUtils.pause(5);
        driver.findElement(purchase).click();
        CommonUtils.pause(5);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();
        CommonUtils.pause(10);

        System.out.println("Payment has done Successfully");


    }


}
