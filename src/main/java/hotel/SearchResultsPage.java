package hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
    private WebDriver webDriver;
    @FindBy(className = "ajax_add_to_cart_button")
    private WebElement bookNowButton;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[3]/a")
    private WebElement proceedToCheckOut;

    public SearchResultsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public String getBookNowButton() {
        return bookNowButton.getText();
    }

    public boolean getIsBookNowVisible() {
        return bookNowButton.isDisplayed();
    }

    public void addHotelToCart() {
        bookNowButton.click();
    }

    public void getProceedToCheckOut() {
        proceedToCheckOut.click();
    }
}
