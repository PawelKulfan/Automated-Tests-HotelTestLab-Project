package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class DuckDuckGoSteps {

    private WebDriver webDriver;

    @Given("an open browser with duckduckgo.com")
    public void openBrowserWithDuckDuckGo(){
        this.webDriver = new ChromeDriver();
        this.webDriver.get("https://duckduckgo.com/");
    }

    @When("user search for {word}")
    public void userSearchForField(String phrase){
        WebElement searchField = this.webDriver.findElement(By.name("q"));
        searchField.clear();
        searchField.sendKeys(phrase);
        searchField.submit();
    }

    @Then("the first result should contain {word}")
    public void firstResultContains(String phrase){
        WebElement firstResult = this.webDriver.findElement(By.xpath("//*[@id=\"r1-0\"]/div[1]/div/a"));
        assertTrue(firstResult.getText().contains(phrase));
    }

    @And("quit browser")
    public void quitBrowser(){
        this.webDriver.quit();
    }

}