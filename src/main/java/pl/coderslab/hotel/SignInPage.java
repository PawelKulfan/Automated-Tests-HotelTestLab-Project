package pl.coderslab.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    private WebDriver webDriver;

    public SignInPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void registerUser(String email){
        WebElement emailAddressInput = this.webDriver.findElement(By.className("is_required"));
        emailAddressInput.sendKeys(email);
        this.webDriver.findElement(By.id("SubmitCreate")).click();
    }
    public void loginUser (String email, String password){
        WebElement emailLogin = this.webDriver.findElement(By.id("email"));
        emailLogin.sendKeys(email);
        WebElement passwordLogin = this.webDriver.findElement(By.id("passwd"));
        passwordLogin.sendKeys(password);
        this.webDriver.findElement(By.id("SubmitLogin")).click();
    }
}
