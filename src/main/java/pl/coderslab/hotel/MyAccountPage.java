package pl.coderslab.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private WebDriver webDriver;

    public MyAccountPage (WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public String getSuccessAllertText () {
        WebElement message = this.webDriver.findElement(By.xpath("//input[@id='field-id_gender-1']"));
        return message.getText();
    }
    public void returnToMainPage (){
        WebElement backToMainPage = this.webDriver.findElement(By.xpath("//a[@title='MyBooking']"));
        backToMainPage.click();
    }

}
