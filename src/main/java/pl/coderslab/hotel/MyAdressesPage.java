package pl.coderslab.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAdressesPage {
    private WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[7]/span[1]")
    private WebElement zipCodeFromMyAddresses;
    public MyAdressesPage (WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public String getZipCodeFromMyAddresses () {
        return zipCodeFromMyAddresses.getText();
    }
}
