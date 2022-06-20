package Framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

import java.io.IOException;

public class ValidatingTest extends Base {
    public WebDriver driver;
    private static Logger log=LogManager.getLogger(ValidatingTest.class.getName());
    @BeforeTest
    public void initialize() throws IOException {
        driver=invokingBrowser();
        driver.get(prop.getProperty("url1"));
        log.info("driver initialised validating test started");
    }
    @Test
    public void validateText() throws IOException {

        LoginPage lp=new LoginPage(driver);
        Assert.assertEquals(lp.getSignInElement().getText(),"Sign in");
        log.info("Validating text test completed successfully");
    }
    @AfterTest
    public void after(){
        driver.close();
    }

}
