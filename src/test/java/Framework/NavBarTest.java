package Framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.NavBarPage;

import java.io.IOException;

public class NavBarTest extends Base {
    public WebDriver driver;
    private static Logger log= LogManager.getLogger(NavBarTest.class.getName());
    @BeforeTest
    public void initialize() throws IOException {
        driver=invokingBrowser();
        driver.get(prop.getProperty("url2"));
        log.info("driver initialised navBar test started");
    }
    @Test
    public void navBarText() throws IOException {
        NavBarPage np=new NavBarPage(driver);
        Assert.assertEquals(np.getNavBarLinks().size(),5);
        log.info("NavBar test completed successfully");
    }
    @AfterTest
    public void after(){
        driver.close();
    }

}
