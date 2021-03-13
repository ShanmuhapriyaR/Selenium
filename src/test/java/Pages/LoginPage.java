package Pages;

import Base.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Driver {

    //Page Factory
    @FindBy(css="#content > div > div > div.card-header > h3")
    WebElement existingUser;

    @FindBy(css="[type='email']")
    WebElement loginEmail;

    @FindBy(css="[type='password']")
    WebElement loginPassword;

    @FindBy(xpath="//input[@name='commit']")          //css=input[name=commit],css=..nav-item
    WebElement loginBtn;

    public LoginPage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    public void login(){
        existingUser.isDisplayed();
        System.out.println(existingUser.getText());
        loginEmail.sendKeys("priya.r0509it@gmail.com");
        loginPassword.sendKeys("Parthivnov#93");
        loginBtn.click();
    }
}