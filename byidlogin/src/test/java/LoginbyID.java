import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginbyID {

  public static void main(String[] args) throws InterruptedException {
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://the-internet.herokuapp.com/login");

//       driver.findElement(By.id("username")).sendKeys("tomsmith");
//       driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//       driver.findElement(By.className("radius")).click();

      driver.findElement(By.name("username")).sendKeys("tomsmith");
      driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
      driver.findElement(By.className("radius")).click();

       Thread.sleep(2000);

       driver.quit();


  }



}
