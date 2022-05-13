package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class IndexPage {
    WebDriver driver;
    public IndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 3), this);
    }

    public WebElement getUsernameInputField() {
        return usernameInputField;
    }

    @FindBy(xpath = "//input[@id='login-form-username']")
    WebElement usernameInputField;
}
