package excecution;

import org.testng.annotations.Test;
import pages.CheckoutPage;

import static base.BrowserSetup.driver;

public class CartClass {

    @Test
    public void checkut(){

        CheckoutPage cr = new CheckoutPage(driver);
        cr.chkout();
        cr.overview();


    }

}
