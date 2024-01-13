package pl.coderslab;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.hotel.CreateAccount;
import pl.coderslab.hotel.SignInPage;
import pl.coderslab.hotel.MainPage;
import pl.coderslab.hotel.MyAccountPage;

import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class HotelRegistrationTest {

    // Atrybut webdriver -> dzięki temu możemy wykorzystać go między metodami testowymi
    private WebDriver driver;

    // Generujemy email i będąc atrybutem możemy z niego korzystać wielokrotnie
    private String email;
    String firstName;
    String lastName;
    String password;


    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        this.driver = new ChromeDriver();
        // Oczekuj niejawnie na pojawienie sie elementu.
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get("https://hotel-testlab.coderslab.pl/en/");
        this.email = "test@test" + new Random().nextInt(1000000) + ".com";
        firstName = "Jan";
        lastName = "Kowalski";
        int random = new Random().nextInt(2000);
        password = "Test" + random;
    }

    @After
    public void tearDown() {
//        this.driver.quit();
    }


    @Test
    public void isPossibleToRegisterNewUser() {
        WebElement signInButton = this.driver.findElement(By.className("user_login"));
        signInButton.click();
        WebElement emailAddressInput = this.driver.findElement(By.className("is_required"));
        emailAddressInput.sendKeys(this.email);
        this.driver.findElement(By.id("SubmitCreate")).click();

        WebElement customerNameInput = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[1]/div[2]/input"));
        customerNameInput.sendKeys("Jan");
        WebElement customerLastNameInput = this.driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        customerLastNameInput.sendKeys("Sobieski");
        WebElement emailInput = this.driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailInput.clear();
        emailInput.sendKeys(email);
        WebElement passwordInput = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[1]/div[5]/input"));
        passwordInput.sendKeys("12345");
        WebElement submitButton = this.driver.findElement(By.xpath("//*[@id=\"submitAccount\"]"));
        submitButton.click();

        try {
            WebElement successAlert = this.driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]"));
            assertEquals("Your account has been created.", successAlert.getText()); // Sprawdzamy czy rzeczywiscie utworzylo nowego uzytkownika
        } catch (NoSuchElementException ex) {
            fail("Alert o sukcesie sie nie pojawil"); // Sami ustalamy, ze test nie przeszedl w tym wypadku
      }
    }
    //Tym razem Twój test powinien sprawdzać możliwość wyszukania hotelu po nazwie.
    //Sekwencja kroków:
    //    logowanie użytkownika
    //    wyszukiwarka na stronie głównej
    //    wyszukaj dowolny hotel.
    @Test
    public void isPossibleToRegisterNewUserPOM(){
        MainPage mainPage = new MainPage(this.driver);
        mainPage.goToLoginPage();
        SignInPage loginPage = new SignInPage(this.driver);
        loginPage.registerUser(this.email);
        CreateAccount createAccount = new CreateAccount(this.driver);
        createAccount.CreateAccount(firstName, lastName, password);
        try {
            MyAccountPage accountPage = new MyAccountPage(driver);
            assertEquals("Your account has been created.", accountPage.getSuccessAllertText()); // Sprawdzamy czy rzeczywiscie utworzylo nowego uzytkownika
        } catch (NoSuchElementException ex) {
            fail("Alert o sukcesie sie nie pojawil"); // Sami ustalamy, ze test nie przeszedl w tym wypadku
        }
    }
    @Test
    public void searchForHotel(){
        String email = "test13012024@test.pl";
        String password = "test13012024";
        String checkInDate = "01-03-2024";
        String checkOutDate = "02-03-2024";
        MainPage mainPage = new MainPage(this.driver);
        mainPage.goToLoginPage();
        SignInPage signInPage = new SignInPage(this.driver);
        signInPage.loginUser(email, password);
        MyAccountPage myAccountPage = new MyAccountPage(this.driver);
        myAccountPage.returnToMainPage();
        mainPage.searchHotel(checkInDate, checkOutDate);
    }

}