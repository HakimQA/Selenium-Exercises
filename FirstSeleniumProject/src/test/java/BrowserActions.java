import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserActions {

    WebDriver driver;


    @Test
    public void firstTest() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        navigation("https://www.facebook.com/");
//        navigateforward();
//        navigatebackward();
//        refresh();
        maximise();
        //minimise();
        //fullscreen();
//        setposition();
//        setdimension();
        getcurrenturl();
        gettitle();
        // getsource();
        windowhandle();
        driver.switchTo().newWindow(WindowType.TAB);
        windowhandle();
        //close();
        quit();


    }


    public void navigation(String url) {
        driver.navigate().to(url);
    }

    public void navigateforward() {
        driver.navigate().forward();
    }

    public void navigatebackward() {
        driver.navigate().back();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void maximise() {
        driver.manage().window().maximize();
    }

    public void minimise() {
        driver.manage().window().minimize();
    }

    public void fullscreen() {
        driver.manage().window().fullscreen();
    }

    public void setposition() {
        Point point = new Point(10, 20);
        driver.manage().window().setPosition(point);
    }

    public void setdimension() {
        Dimension dimension = new Dimension(1366, 1024);
        driver.manage().window().setSize(dimension);
    }

    public void getcurrenturl() {
        String URL = driver.getCurrentUrl();
        System.out.println("The Current URL is " + URL);
    }

    public void gettitle() {
        String title = driver.getTitle();
        System.out.println("The Current URL is " + title);
    }

    public void getsource() {
        String source = driver.getPageSource();
        System.out.println("The Page Souce is " + source);
    }

    public void windowhandle() {
        String window = driver.getWindowHandle();
        System.out.println("The Window Handle ID is " + window);
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

}