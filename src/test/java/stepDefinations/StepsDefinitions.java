package stepDefinations;

import Framework.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

import java.io.IOException;

public class StepsDefinitions  extends Base {
    LoginPage lp;
    @Given("initialize chrome driver")
    public void initialize_chrome_driver() throws IOException {
        driver=invokingBrowser();
    }
    @Given("navigate to {string}")
    public void navigate_to(String string) {
        driver.get(string);
    }
    @Given("click on My Account")
    public void click_on_my_account() {
        LandingPage page=new LandingPage(driver);
        lp=page.getMyAccount();
    }
//    @When("user enter the username {string} and password {string}")
//    public void user_enter_the_username_and_password(String string, String string2) {
//        lp.getUserName().sendKeys(string);
//        lp.getPassword().sendKeys(string2);
//        lp.getLoginButton().click();
//
//    }
    @When("^user enter the (.+)  and (.+)$")
    public void user_enter_the_and(String username, String password) throws Throwable {
        lp.getUserName().sendKeys(username);
        lp.getPassword().sendKeys(password);
        lp.getLoginButton().click();
    }
    @Then("validate user logged in successfully")
    public void validate_user_logged_in_successfully() {
        MyAccountPage map=new MyAccountPage(driver);
        String[] text=map.getTextToValidate().getText().split("not");
        Assert.assertEquals(text[0],"Hello testingperson (");
        driver.close();

    }
}
