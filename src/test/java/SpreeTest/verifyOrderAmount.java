package SpreeTest;

import Base.Driver;
import Pages.Homepage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class verifyOrderAmount extends Driver {
@Test
    public void checkOutPage() throws InterruptedException {
        Homepage home = new Homepage(driver);
        home.LogInLink();
        LoginPage login = new LoginPage(driver);
        login.login();
        MyAccountPage myAccount = new MyAccountPage(driver);
        assertTrue(myAccount.selectProduct("Ruby on Rails Mug"));
        myAccount.addProductToCart();
        myAccount.checkOut();
        Assert.assertEquals(myAccount.cartAmt,myAccount.orderTotalCheckout);
        System.out.println(myAccount.cartAmt+" and "+myAccount.orderTotalCheckout+ " are equal");
        //myAccount.deleteCartItems();

    }
}
