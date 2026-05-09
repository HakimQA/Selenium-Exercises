package Static_Dropdown_Excercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Rahulshettyacdmy {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/?utm_source=chatgpt.com");
        WebElement dropdownbx = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); // Locate the Dropdown Box
        Select dropdwn = new Select(dropdownbx); // Create an Object for the Dropdown box
        List<WebElement> options = dropdwn.getOptions();
        System.out.println("The Options available in the Dropdown are : ");
        for (WebElement option: options){
            System.out.println( option.getText());
        }

        dropdwn.selectByVisibleText("USD");
        WebElement selectusd = dropdwn.getFirstSelectedOption();
        System.out.println("The Selected Currency is " +selectusd.getText());

        dropdwn.selectByVisibleText("INR");
        WebElement selectinr = dropdwn.getFirstSelectedOption();
        if (selectinr.getText().equalsIgnoreCase("INR")){
            System.out.println("The Selected Currency has changed to " + selectinr.getText());
        }else {
            System.out.println("The Selected Currency is not INR and it is " + selectinr.getText());
        }

         driver.quit();

    }
}
