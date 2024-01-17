package hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
    private WebDriver webDriver;
    @FindBy(className = "alert-success")
    private WebElement orderConfirmedMessage;
    public OrderConfirmationPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public boolean orderConfirmed() {
        return orderConfirmedMessage.isDisplayed();
    }
}
