package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    private By userName=By.id("username");
    private By password=By.name("password");
    private By login=By.name("login");

    //url1
    private By text=By.xpath("//form[@class='form']/h1");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement getUserName() {
        return driver.findElement(userName);
    }
    public WebElement getPassword() {
        return driver.findElement(password);
    }
    public WebElement getLoginButton() {
        return driver.findElement(login);
    }

    public WebElement getSignInElement() {
        return driver.findElement(text);
    }

}
