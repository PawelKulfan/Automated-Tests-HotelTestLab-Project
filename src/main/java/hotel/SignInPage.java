package hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver webDriver;
    @FindBy(className = "is_required")
    private WebElement emailAddressInput;
    @FindBy(id = "passwd")
    private WebElement passwordLogin;
    @FindBy(id = "email")
    private WebElement emailLogin;
    @FindBy(id = "SubmitLogin")
    private WebElement submitButton;
    @FindBy(id = "SubmitCreate")
    private WebElement createAccount;
    public SignInPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public void registerUser(String email){
        emailAddressInput.sendKeys(email);
        createAccount.click();
    }
    public void loginUser (String email, String password){
        emailLogin.sendKeys(email);
        passwordLogin.sendKeys(password);
        submitButton.click();
    }
}
