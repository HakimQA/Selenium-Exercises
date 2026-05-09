package excecution;

import org.testng.annotations.Test;
import pages.Products;
import static base.BrowserSetup.driver;

public class ProductClass{

    @Test

    public void productcrt(){

        Products pr = new Products(driver);
        pr.product();


    }

}
