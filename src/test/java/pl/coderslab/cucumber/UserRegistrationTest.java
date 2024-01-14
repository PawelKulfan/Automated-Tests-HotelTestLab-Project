package pl.coderslab.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber/features/user-registration.feature",
        plugin = {"pretty", "html:report.html"})//formatowanie i zapisanie do pliku html
public class UserRegistrationTest {
}