package pl.coderslab.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

public class MainPage {
    private WebDriver webDriver;
    public MainPage (WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void goToLoginPage (){
        WebElement signInButton = this.webDriver.findElement(By.className("user_login"));
        signInButton.click();
    }
    public void searchHotel (String checkInDate, String checkOutDate){
        WebElement selectHotelField = this.webDriver.findElement(By.id("hotel_cat_name"));
        selectHotelField.click();
        WebElement selectHotel = this.webDriver.findElement(By.className("hotel_name"));
        selectHotel.click();
        WebElement selectStartDate = this.webDriver.findElement(By.id("check_in_time"));
        selectStartDate.click();
        selectStartDate.sendKeys(checkInDate);
        WebElement selectEndDate = this.webDriver.findElement(By.id("check_out_time"));
        selectEndDate.click();
        selectEndDate.sendKeys(checkOutDate);
        WebElement clickSubmit = this.webDriver.findElement(By.id("search_room_submit"));
        clickSubmit.click();
    }
}
