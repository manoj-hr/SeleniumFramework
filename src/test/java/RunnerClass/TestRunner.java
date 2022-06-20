package RunnerClass;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import org.testng.annotations.Test;

//@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "",
        features = "src\\test\\java\\features\\Login.feature\\",
        glue = "stepDefinations\\StepsDefinitions.java")
public class TestRunner extends AbstractTestNGCucumberTests {

}
