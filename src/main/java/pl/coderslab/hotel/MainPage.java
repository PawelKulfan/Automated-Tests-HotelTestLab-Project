package pl.coderslab.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;

public class MainPage {
    private WebDriver webDriver;
    @FindBy(className = "user_login")
    private WebElement signInButton;
    @FindBy(id = "hotel_cat_name")
    private WebElement selectHotelField;
    @FindBy(className = "hotel_name")
    private WebElement selectHotel;
    @FindBy(id = "check_in_time")
    private WebElement selectStartDate;
    @FindBy(id = "check_out_time")
    private WebElement selectEndDate;
    @FindBy(id = "search_room_submit")
    private WebElement clickSubmit;

    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void goToLoginPage() {
        signInButton.click();
    }

    public boolean isSignButtonVisible() {
        return signInButton.isDisplayed();
    }

    public void searchHotel (String checkInDate, String checkOutDate){
        selectHotelField.click();
        selectHotel.click();
        selectStartDate.click();
        selectStartDate.sendKeys(checkInDate);
        selectEndDate.click();
        selectEndDate.sendKeys(checkOutDate);
        clickSubmit.click();
    }

}

