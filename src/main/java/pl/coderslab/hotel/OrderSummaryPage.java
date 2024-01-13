package pl.coderslab.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
    private WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    private WebElement orderSummaryButton;
    public OrderSummaryPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public void orderConfirmation () {
        orderSummaryButton.click();
    }

}
