package pl.coderslab.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.hotel.*;

import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class HotelSteps {
    private WebDriver webDriver;
    @Given("An open browser with user registration page")
    public void openBrowserWithHotelPage () {
        this.webDriver = new ChromeDriver();
        this.webDriver.get("https://hotel-testlab.coderslab.pl/en/login?back=my-account");
    }
    @When("User registers with valid credentials: {word} {word} {word}")
    public void puttingValidEmail (String firstName, String lastName, String password) {
        SignInPage loginPage = new SignInPage(this.webDriver);
        String email = "test" + new Random().nextInt(1000000) + "@test.com";
        loginPage.registerUser(email);
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CreateAccount createAccount = new CreateAccount(this.webDriver);
        createAccount.CreateAccount(firstName, lastName, password);
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
    @Given("An open browser with logged user")
    public void openHotelPageOnMyAccountPage () {
        this.webDriver = new ChromeDriver();
        this.webDriver.get("https://hotel-testlab.coderslab.pl/en/login?back=my-account");
        SignInPage signInPage = new SignInPage(this.webDriver);
        signInPage.loginUser("test13012024@test.pl", "test13012024");
    }
    @When("User adds new delivery adress to My Account page")
    public void addingFirstAdress () {
        MyAccountPage myAccountPage = new MyAccountPage(this.webDriver);
        myAccountPage.addFirstAddressPage();
        AddAdressPage addAdressPage = new AddAdressPage(this.webDriver);
        addAdressPage.setAdressData("Mickiewicza 1", "11-033", "Warsaw", "5346462", "4654654546");
    }
    @Then("First adress added to My Account page")
    public void addressSuccesfullyAdded () {
        MyAdressesPage myAdressesPage = new MyAdressesPage(this.webDriver);
        assertEquals("11-033", myAdressesPage.getZipCodeFromMyAddresses());
    }
}
