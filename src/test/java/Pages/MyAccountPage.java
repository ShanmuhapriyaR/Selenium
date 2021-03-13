package Pages;

import Base.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyAccountPage extends Driver {
    public double value;
    public String[] priceVal = new String[2];
    public String cartAmt;
    public String orderTotalCheckout;
    public String alert;

    //Page Factory
    @FindBy(css = ".alert.alert-success")
    WebElement loginMsg;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logOutBtn;

    @FindBy(xpath = "//div[@class='alert alert-notice']")
    WebElement logOutMsg;
//--------------------------------------------------------
    @FindBy(css = "#keywords")
    WebElement searchField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement searchBtn;

    @FindBys(@FindBy(css = "#content"))
    List<WebElement> searchResultsPanel;

    @FindBy(linkText = "Bags")
    WebElement bagLink;

    @FindBy(xpath = "//input[@class = 'btn btn-primary']")            //(css = "[type='submit']")
    WebElement searchFilter;

    @FindBy(xpath = "//span[@itemprop='price']")
    WebElement priceProperty;

    @FindBy(css = "#sidebar_products_search > div > ul > li:nth-child(3)")
    WebElement priceRangeLink;

    @FindBys(@FindBy(css = "span[class='price selling lead']"))
    public List<WebElement> productsRelatedToBags;
    //--------------------------------------------------
    @FindBy(xpath = "//a[@href='/products/ruby-on-rails-mug']")
    WebElement RubyOnRailsMugProd;

    @FindBy(css = "#add-to-cart-button")
    public WebElement addToCartLink;

    @FindBy(css = "#link-to-cart > a > span.amount")
    public WebElement cartAmount;

    @FindBy(css = "#cart-detail > tbody:nth-child(3) > tr > td.lead")
    public WebElement orderTotalCart;

    @FindBy(css ="#checkout-link")
    WebElement checkOutButton;

    @FindBy(css = "#summary-order-total")
    WebElement orderTotalCheckoutPage;

    @FindBy(css = "#quantity")
    WebElement prodQuantity;

    @FindBy(css = "#add-to-cart-button")
    WebElement addToCartMultipleProducts;

    @FindBy(xpath = "//span[@class='glyphicon glyphicon-minus-sign']")
    WebElement deleteItemsInCart;

    @FindBy(css = "#content > div > div > div")
    WebElement emptyCartAlertMessage;


    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLoginMsg() {
        return loginMsg.getText();
    }

    public void logout() {

        logOutBtn.isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(logOutBtn));
        logOutBtn.click();
    }

    public String getLogOutMsg() {
        return logOutMsg.getText();
    }

    public boolean searchProduct(String product) {
        searchField.clear();
        searchField.sendKeys(product);
        searchBtn.click();
        for (int i = 0; i < searchResultsPanel.size(); i++) {
            boolean flag = searchResultsPanel.get(i).getText().contains(product);
            System.out.println(searchResultsPanel.get(i).getText());
            if (!(flag))
                return false;
        }
        return true;
    }

    public void filterProducts() {
        bagLink.click();
        priceRangeLink.click();
        searchFilter.click();
        for (int i = 0; i < productsRelatedToBags.size(); i++) {
            String price = productsRelatedToBags.get(i).getText().replaceAll("\\$", "");
            priceVal[i] = price;
            value = Double.parseDouble(priceVal[i]);
        }
    }

    public boolean selectProduct(String item) {
        searchField.clear();
        searchField.sendKeys(item);
        searchBtn.click();
        System.out.println(RubyOnRailsMugProd.getText());
        RubyOnRailsMugProd.click();
        return true;
    }

    public void addProductToCart(){
        addToCartLink.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        cartAmt = cartAmount.getText();
        System.out.println(cartAmt);
    }

    public void checkOut() {

        checkOutButton.click();
        orderTotalCheckout = orderTotalCheckoutPage.getText();
        System.out.println(orderTotalCheckout);
        System.out.println("Cart amount " + " ' " + cartAmt + " ' " + " and total amount " + " ' " + orderTotalCheckout + " ' " + "are equal");
    }
    public void addThreeProducts() {
        prodQuantity.clear();
        prodQuantity.sendKeys("3");
        addToCartMultipleProducts.click();
    }

    public void deleteCartItems(){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        deleteItemsInCart.click();
    }

    public String clearCart(){
       alert = emptyCartAlertMessage.getText();
       return alert;
    }
}


