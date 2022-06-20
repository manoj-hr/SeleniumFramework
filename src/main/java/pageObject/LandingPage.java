package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;

    private By account=By.linkText("My Account");

    public LandingPage(WebDriver driver) {
        this.driver=driver;
    }

    public LoginPage getMyAccount() {
        driver.findElement(account).click();
        LoginPage lp=new LoginPage(driver);
        return lp;
    }
}
