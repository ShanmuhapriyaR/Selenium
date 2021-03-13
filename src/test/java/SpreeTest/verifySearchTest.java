package SpreeTest;

import Base.Driver;
import org.testng.annotations.Test;
import Pages.MyAccountPage;
import static org.testng.Assert.assertTrue;

public class verifySearchTest extends Driver {
    @Test
    public void searchText() throws InterruptedException {

        MyAccountPage myAccount = new MyAccountPage(driver);
        assertTrue(myAccount.searchProduct("Ruby"));
        System.out.println("------------------------------");
        assertTrue(myAccount.searchProduct("Apache"));

    }
}
