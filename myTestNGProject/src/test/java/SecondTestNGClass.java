import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondTestNGClass
{
    WebDriver driver;

    @BeforeTest

    public void prepare(){
        System.out.println("Opening the Browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }


    @Test
    public void openBrowser() throws InterruptedException {
        System.out.println("Opening the Browser");
        driver.navigate().to("https://twitter.com/");
        Thread.sleep(3000);
    }

    @Test
    public void singup(){
        System.out.println("Singing up");
    }


    @Test
    public void login(){
        System.out.println("Login to the site");

    }

    @Test
    public void addToCart(){
        System.out.println("Add items to the cart");
    }

    @Test
    public void logout(){
        System.out.println("Logging out");
    }


    @Test
    public void closeBrowser(){
        System.out.println("Closing the Browser");
    }






}
