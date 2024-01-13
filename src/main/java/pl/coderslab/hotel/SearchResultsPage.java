package pl.coderslab.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
    private WebDriver webDriver;

    public SearchResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getSearchSuccesText() {
        WebElement searchSuccesText = this.webDriver.findElement(By.className("ajax_add_to_cart_button"));
        return searchSuccesText.getText();
    }

    public boolean getIsBookNowVisible() {
        WebElement isBookNowVisible = this.webDriver.findElement(By.className("ajax_add_to_cart_button"));
        return isBookNowVisible.isDisplayed();
    }

    public void addHotelToCart() {
        WebElement bookNowButton = this.webDriver.findElement(By.className("ajax_add_to_cart_button"));
        bookNowButton.click();
    }

    public String getHotelAddedToCartMessage() {
        WebElement hotelAddedToCartMessage = this.webDriver.findElement(By.className("layer_cart_product"));
        return hotelAddedToCartMessage.getText();

    }
}
