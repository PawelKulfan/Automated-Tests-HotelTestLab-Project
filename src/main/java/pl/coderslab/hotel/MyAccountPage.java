package pl.coderslab.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private WebDriver webDriver;
    @FindBy(xpath = "//input[@id='field-id_gender-1']")
    private WebElement message;
    @FindBy(xpath = "//a[@title='MyBooking']")
    private WebElement backToMainPage;

    public MyAccountPage (WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public String getSuccessAllertText () {
        return message.getText();
    }
    public void returnToMainPage (){
        backToMainPage.click();
    }

}
