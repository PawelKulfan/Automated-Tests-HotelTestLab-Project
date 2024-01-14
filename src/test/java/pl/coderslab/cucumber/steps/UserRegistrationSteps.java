package pl.coderslab.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_lol.AN;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.hotel.CreateAccount;
import pl.coderslab.hotel.SignInPage;

import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class UserRegistrationSteps {
    private WebDriver webDriver;
    @Given("An open browser with user registration page")
    public void openBrowserWithHotelPage () {
        this.webDriver = new ChromeDriver();
        this.webDriver.get("https://hotel-testlab.coderslab.pl/en/login?back=my-account");
    }
    @When("User registers with valid credentials")
    public void puttingValidEmail () {
        SignInPage loginPage = new SignInPage(this.webDriver);
        String email = "test" + new Random().nextInt(1000000) + "@test.com";
        loginPage.registerUser(email);
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CreateAccount createAccount = new CreateAccount(this.webDriver);
        createAccount.CreateAccount("Jan", "Kowalski", "test231234");
    }
    @Then("New user account created")
    public void accountSuccesflullyCreated () {
        WebElement successAlert = this.webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]"));
        assertEquals("Your account has been created.", successAlert.getText());
    }
    @And("Quit browser")
    public void quitBrowser(){
        this.webDriver.quit();
    }
}
