package tests;

import base.BaseTest;
import net.bytebuddy.build.Plugin;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.WaitUtils;

import java.time.Duration;

public class FlightBookingTest {

    public WebDriver driver;
    WaitUtils waitUtils;
    public FlightBookingTest(WebDriver driver){
        this.driver=driver;
         waitUtils = new WaitUtils(driver);
    }




    public void frmcity(String fcity){
        By frmbox = By.xpath("//div[@data-testid='to-testID-origin']");
        By cityslct = By.xpath("//div[text()='"+fcity+"']");
        driver.findElement(frmbox).click();
        driver.findElement(cityslct).click();
        WebElement selectedfromcity = driver.findElement(By.xpath("//input[contains(@value,'"+fcity+"')]"));
        System.out.println("The Selected From City is : " + selectedfromcity.getAttribute("value"));


    }


    public void tocity(String tcity){
        By tobox = By.xpath("//div[@data-testid='to-testID-destination']");
        By intrntinl = By.xpath("//div[text()='International']");

        String International = driver.findElement(intrntinl).getText();
        By cityslt = By.xpath("//div[text()='"+tcity+"']");
        driver.findElement(tobox).click();
        waitUtils.wait.until(
                ExpectedConditions.visibilityOfElementLocated(intrntinl)
        );
        Assert.assertEquals(International,"International");
        driver.findElement(intrntinl).click();
        driver.findElement(cityslt).click();
        WebElement selectedtocity = driver.findElement(By.xpath("//input[contains(@value,'"+tcity+"')]"));
        System.out.println("The Selected To City is : " + selectedtocity.getAttribute("value"));



    }

    public void deprtdate(String month, String day) throws InterruptedException {

        //By deprtdtbox = By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']//div[@class='css-1dbjc4n']");
        //driver.findElement(deprtdtbox).click();
        Thread.sleep(10000);
        waitUtils.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='undefined-calendar-picker']")));



//        if (!currntmnth.equals(month)){
//            Thread.sleep(5000);
//            driver.findElement(By.xpath("((//*[local-name()='svg' and @data-testid='svg-img'])/parent::div)[18]")).click();
//            Thread.sleep(5000);
//            currntmnth = driver.findElement(By.xpath("//div[contains(@data-testid,'undefined-month-" + month + "')]//div//div[text()='2026']")).getText();
//            System.out.println(currntmnth);
//            Thread.sleep(5000);
//
//        }
//        Thread.sleep(10000);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement dayselect = wait.until(
//                ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='undefined-month-" + month + "']//div[@data-testid='undefined-calendar-day-" + day + "']")));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        js.executeScript("arguments[0].scrollIntoView(true);", dayselect);
//
//        Thread.sleep(500);
//
//        js.executeScript("arguments[0].click();", dayselect);


           while(true){

               WebElement currentMonthElement = driver.findElement(
                       By.xpath("(//div[contains(@data-testid,'undefined-month')])[1]"));
               String currentMonth =
                       currentMonthElement.getAttribute("data-testid");
               System.out.println(currentMonth);
               if(currentMonth.equals(month)){
                   break;
               }
               driver.findElement(
                               By.xpath("((//*[local-name()='svg' and @data-testid='svg-img'])/parent::div)[18]"))
                       .click();

               Thread.sleep(5000);



           }
        String dayXpath =
                "//div[@data-testid='undefined-month-" + month + "']" +
                        "//div[@data-testid='undefined-calendar-day-" + day + "']";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dayselect = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(dayXpath)));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", dayselect);

        Thread.sleep(500);

        js.executeScript("arguments[0].click();", dayselect);




            String deprtvle = driver.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar']")).getText();
            System.out.println("The Selected Deaprture Date is : " + deprtvle);



    }





}
