package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NavBarPage {
    public WebDriver driver;

    private By links= By.cssSelector(".btn-primary");

    public NavBarPage(WebDriver driver) {
        this.driver=driver;
    }

    public List<WebElement> getNavBarLinks(){
        return driver.findElements(links);
    }
}
