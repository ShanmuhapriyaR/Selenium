package SpreeTest;

import Base.Driver;
import Pages.Homepage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyClearCartTest extends Driver {
    @Test
    public void clearCart() throws InterruptedException{
        Homepage home = new Homepage(driver);
        home.LogInLink();
        LoginPage login = new LoginPage(driver);
        login.login();
        MyAccountPage myAccount = new MyAccountPage(driver);
        Assert.assertTrue(myAccount.selectProduct("Ruby on Rails Mug"));
        myAccount.addThreeProducts();
        myAccount.deleteCartItems();
        myAccount.clearCart();
        Assert.assertEquals(myAccount.alert,"Your cart is empty");

    }
}
