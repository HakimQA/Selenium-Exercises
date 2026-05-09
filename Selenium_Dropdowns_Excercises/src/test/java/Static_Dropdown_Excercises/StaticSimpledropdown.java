package Static_Dropdown_Excercises;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StaticSimpledropdown {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Dropdown']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));
        WebElement dropdownelement = driver.findElement(By.id("dropdown")); // Locate the Dropdown Box
        Select dropdown = new Select(dropdownelement); // Create Object to select the options in the Dropdownbox

        List<WebElement> options = dropdown.getOptions();

        boolean found = false;
        for(WebElement option : options){
            if(option.getText().equalsIgnoreCase("option 1")){
                found = true;
                break;
            }
        }

        if (found){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        dropdown.selectByIndex(2);

    }

}