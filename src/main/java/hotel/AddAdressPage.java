package hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAdressPage {
    private WebDriver webDriver;
    @FindBy(id = "address1")
    private WebElement adressField;
    @FindBy(id = "postcode")
    private WebElement zipCodeField;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(id = "phone")
    private WebElement phoneField;
    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;
    @FindBy(id = "submitAddress")
    private WebElement submitAddressButton;


    public AddAdressPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    public void setAdressData (String adress, String zip, String city, String phone, String mobilePhone) {
        adressField.sendKeys(adress);
        zipCodeField.sendKeys(zip);
        cityField.sendKeys(city);
        phoneField.sendKeys(phone);
        mobilePhoneField.sendKeys(mobilePhone);
        submitAddressButton.click();
    }

}
