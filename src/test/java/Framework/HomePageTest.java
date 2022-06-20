package Framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class HomePageTest extends Base {
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		driver=invokingBrowser();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getValue")
	public void loginTest(String username,String password) throws IOException {
//		System.out.println(username+" "+password);
//		System.out.println("loginTest");
		LandingPage page=new LandingPage(driver);
		LoginPage lp=page.getMyAccount();
		lp.getUserName().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLoginButton().click();
		//validate text
		MyAccountPage map=new MyAccountPage(driver);
		String[] text=map.getTextToValidate().getText().split("not");
		Assert.assertEquals(text[0],"Hello testingperson (");

		//Validate DashBorad links
		Assert.assertTrue(map.getOrdersLink().isDisplayed());
		Assert.assertTrue(map.getDownloadsLink().isDisplayed());
		Assert.assertTrue(map.getAddressesLink().isDisplayed());
		Assert.assertTrue(map.getAccountDetailsLink().isDisplayed());
		Assert.assertTrue(map.getLogoutLink().isDisplayed());

	}
	@AfterTest
	public void after(){
		driver.close();
	}

	@DataProvider
	public Object[][] getValue(){
		Object[][] data=new Object[1][2];
		data[0][0]="testingperson@gmail.com";
		data[0][1]="q!w2e#r4";

		return data;
	}

}
