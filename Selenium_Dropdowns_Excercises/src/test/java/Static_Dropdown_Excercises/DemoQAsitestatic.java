package Static_Dropdown_Excercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DemoQAsitestatic {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu?utm_source=chatgpt.com");
        WebElement dropdownbox = driver.findElement(By.id("oldSelectMenu"));
        Select dropdown = new Select(dropdownbox);
        dropdown.selectByIndex(0);
        WebElement selecteditem = dropdown.getFirstSelectedOption();
        System.out.println("Selected Item from the Dropdown is " + selecteditem.getText());
        List<WebElement> options = dropdown.getOptions();
        for(WebElement option : options){

            System.out.println(option.getText());
        }

    }


}
