package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public WebDriverWait wait;
    public WaitUtils(WebDriver driver) {

         this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

}
