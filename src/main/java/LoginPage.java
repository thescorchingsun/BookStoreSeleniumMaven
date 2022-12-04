import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    private By logIn2Btn = By.id("login");
    private By newUserBtn = By.id("newUser");
    private By userNameField = By.id("userName");
    private By passwordField = By.id("password");
    private By getHeadingH2Text = By.xpath ("//div/h2");
    private By getHeadingH5Text = By.xpath ("//div/h5");

    public RegisterPage clickNewUser() {
        driver.findElement(newUserBtn).click();
        return new RegisterPage(driver);
    }

    public ProfilePage clickLogin() {
        driver.findElement(logIn2Btn).click();
        return new ProfilePage(driver);
    }

    public ProfilePage typeUserName (String username) {
        driver.findElement(userNameField).sendKeys(username);
        return new ProfilePage(driver);
    }

    public ProfilePage typePassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
        return new ProfilePage(driver);
    }

    public String GetH2Text() {
        return driver.findElement(getHeadingH2Text).getText();
    }
    public String GetH5Text() {
        return driver.findElement(getHeadingH5Text).getText();
    }






}
