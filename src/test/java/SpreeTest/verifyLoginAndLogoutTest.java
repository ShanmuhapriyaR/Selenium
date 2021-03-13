package SpreeTest;

import Base.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import Pages.Homepage;
import Pages.LoginPage;
import Pages.MyAccountPage;

import static org.testng.Assert.assertEquals;

public class verifyLoginAndLogoutTest extends Driver {


    @Test
    public void LoginAndLogout() throws InterruptedException {
        Homepage home = new Homepage(driver);
        home.LogInLink();
        LoginPage login = new LoginPage(driver);
        login.login();
        MyAccountPage myAccount = new MyAccountPage(driver);
        System.out.println(myAccount.getLoginMsg());
        assertEquals(myAccount.getLoginMsg(), "Logged in successfully");
        System.out.println("-------------------------------");
        myAccount.logout();
        System.out.println(myAccount.getLogOutMsg());
        System.out.println("-------------------------------");
        assertEquals(myAccount.getLogOutMsg(), "Signed out successfully.");
    }
}


