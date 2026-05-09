package test;

import base.BrowserSetup;
import org.testng.annotations.Test;
import pages.AddtoCart;
import pages.Product;

public class ProductSearch extends BrowserSetup {

    @Test
    public void prodsearch() {
        Product pd = new Product(driver);
        pd.productsearch();
    }

    @Test(priority = 1)
    public void cartvrfktion(){
        AddtoCart ad = new AddtoCart(driver);
        ad.cartverifction();
    }


}
