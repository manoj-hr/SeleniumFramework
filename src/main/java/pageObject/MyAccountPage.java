package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    public WebDriver driver;


    private By validateText=By.xpath("//div[@class='woocommerce-MyAccount-content']");
    private By orders=By.linkText("Orders");
    private By download=By.linkText("Downloads");
    private By address=By.linkText("Addresses");
    private By account_details=By.linkText("Account Details");
    private By logout=By.linkText("Logout");

    public MyAccountPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getTextToValidate(){
        return driver.findElement(validateText);
    }
    public WebElement getOrdersLink(){
        return driver.findElement(orders);
    }
    public WebElement getDownloadsLink(){
        return driver.findElement(download);
    }
    public WebElement getAddressesLink(){
        return driver.findElement(address);
    }
    public WebElement getAccountDetailsLink(){
        return driver.findElement(account_details);
    }
    public WebElement getLogoutLink(){
        return driver.findElement(logout);
    }

}
