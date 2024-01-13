package pl.coderslab.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProceedToCheckOutPage {
    private WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div[6]/div/div/h3")
    private WebElement paymentType;
    public ProceedToCheckOutPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public boolean paymentTypeIsVisible() {
        return paymentType.isDisplayed();
    }
}
