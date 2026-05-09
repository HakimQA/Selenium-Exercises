package excecution;

import org.testng.annotations.Test;
import pages.CartPage;

import static base.BrowserSetup.driver;

public class AddtoCartClass {

    @Test

    public void addcrt(){

        CartPage cp = new CartPage(driver);
        cp.cartpage();

    }

}
