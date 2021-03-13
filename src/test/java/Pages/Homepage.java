package Pages;


import Base.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class Homepage extends Driver {

        @FindBy(css=".nav-link.text-white")    //css = a.nav-link.text-white
        WebElement loginLink;

        public Homepage(WebDriver driver)
        {
            PageFactory.initElements(driver, this);
        }

        public void LogInLink()
        {
            loginLink.click();
        }
    }

