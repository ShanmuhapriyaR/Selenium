package SpreeTest;
import Base.Driver;
import Pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyFilterTest extends Driver {
    @Test
    public void filterList() throws InterruptedException {
        MyAccountPage myAccount2 = new MyAccountPage(driver);
        myAccount2.filterProducts();
        for(int i=0;i<myAccount2.productsRelatedToBags.size();i++)
        {
            Assert.assertTrue(myAccount2.value >= 15 && myAccount2.value <= 18);
            System.out.println("Products price is within the range ");
        }

    }
}

