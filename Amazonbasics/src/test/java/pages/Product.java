package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonWait;

import java.time.Duration;
import java.util.List;

public class Product {

    WebDriver driver;

    public Product(WebDriver driver){

        this.driver = driver;

    }




    By searchbar = By.xpath("//input[@id='twotabsearchtextbox']");
    By searchbutton = By.xpath("//input[@id='nav-search-submit-button']");
    By brndchkbx = By.xpath("//div[@id='brandsRefinements']//ul//li//i");
    By pricernge = By.xpath("//div[@id='priceRefinements']//ul//span[@class='a-declarative']//li[@id='p_36/dynamic-picker-1']//a");
    By productname = By.xpath("//div[@role='listitem']//div[@data-cy='title-recipe']/a");
    By prodcttitle = By.xpath("//span[@id='productTitle']");





    public void productsearch(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Amazon"));

        String pagetitle = driver.getTitle();



        if(pagetitle.toLowerCase().contains("amazon")){
            System.out.println("The Page has succesfully Loaded");
            System.out.println(pagetitle);
        }else {

            throw new AssertionError("Wrong page loaded: " + pagetitle);

        }

      driver.findElement(searchbar).sendKeys("iphone");
      CommonWait.pause(5);
      driver.findElement(searchbutton).click();
      CommonWait.pause(5);
      driver.findElement(brndchkbx).click();
      CommonWait.pause(5);
      driver.findElement(pricernge).click();
      CommonWait.pause(5);

        List<WebElement> products = driver.findElements(By.xpath("//div[@role='listitem']//div[@data-cy='title-recipe']"));

        for (WebElement product : products) {
            String title = product.getText().toLowerCase();

            if (!(title.contains("apple") || title.contains("iphone"))) {
                System.out.println("Invalid product: " + title);
                throw new AssertionError("Product does not match search criteria");
            }

        }


        for (WebElement product1 : products){
            System.out.println(product1.getText());
        }

      CommonWait.pause(10);
      int beforeClick = driver.getWindowHandles().size();
      driver.findElement(productname).click();
      CommonWait.pause(10);
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
      int afterClick = driver.getWindowHandles().size();
      CommonWait.pause(10);
      if(afterClick>beforeClick){
          System.out.println("New Tab has been opened");
      }else {
          System.out.println("No new tab has been opened");
      }

      CommonWait.pause(10);

      WebElement prodtitle = driver.findElement(prodcttitle);
      if (prodtitle.isDisplayed()){

          System.out.println("Product Title has verified and the Title is : " + prodtitle.getText());
      }else {

          throw new AssertionError("Product title is NOT displayed");

      }

    }


}
