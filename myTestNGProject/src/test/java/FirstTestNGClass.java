import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNGClass
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
        System.out.println("Closing the Browser");
        driver.quit();
    }


    @Test (priority = 1)
    public void loadingpage() throws InterruptedException {
        System.out.println("Loading the Page");
        driver.navigate().to("https://mvnrepository.com/");
        Thread.sleep(10000);
    }

    @Test (priority = 2)
    public void singup(){
        System.out.println("Singing up");
    }


    @Test (priority = 3)
    public void login(){
        System.out.println("Login to the site");

    }

    @Test (priority = 4)
    public void addToCart(){
        System.out.println("Add items to the cart");
    }

    @Test (priority = 5)
    public void logout(){
        System.out.println("Logging out");
    }








}
