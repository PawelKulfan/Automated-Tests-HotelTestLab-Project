package pl.coderslab.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccount {
    private WebDriver webDriver;
    //String email;

    public CreateAccount (WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void CreateAccount (String firstName, String lastName, String password ) {
        WebElement customerNameInput = this.webDriver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[1]/div[2]/input"));
        customerNameInput.sendKeys(firstName);
        WebElement customerLastNameInput = this.webDriver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        customerLastNameInput.sendKeys(lastName);
//        WebElement emailInput = this.webDriver.findElement(By.xpath("//*[@id=\"email\"]"));
//        emailInput.clear();
//        emailInput.sendKeys(this.email);
        WebElement passwordInput = this.webDriver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[1]/div[5]/input"));
        passwordInput.sendKeys(password);
        WebElement submitButton = this.webDriver.findElement(By.xpath("//*[@id=\"submitAccount\"]"));
        //Thread.sleep(2000);//zatrzymuje działanie programu na określonąilość czasu
        submitButton.click();
    }
}
