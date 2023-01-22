import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    private WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameField = By.id("userName");
    private By passwordField = By.id("password");
    private By logIn2Btn = By.id("login");
    private By newUserBtn = By.id("newUser");
    private By getHeadingH2Text = By.xpath ("//div/h2");
    private By getHeadingH5Text = By.xpath ("//div/h5");
    private By ErrorText = By.xpath ("//form/div[5]/div/p[@id='name']");


    public SignUpPage clickLogin() {
        driver.findElement(logIn2Btn).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickNewUser() {
        driver.findElement(newUserBtn).click();
        return new SignUpPage(driver);
    }

    public ProfilePage TypeUserName (String username) {
        driver.findElement(userNameField).sendKeys(username);
        return new ProfilePage(driver);
    }

    public ProfilePage TypePassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
        return new ProfilePage(driver);
    }

    public String GetH2Text() {
        return driver.findElement(getHeadingH2Text).getText();
    }
    public String GetH5Text() {
        return driver.findElement(getHeadingH5Text).getText();
    }
    public String GetErrorText() {
        return driver.findElement(ErrorText).getText();
    }


    public ProfilePage LogIn (String username, String password) {
        this.TypeUserName(username);
        this.TypePassword(password);
        driver.findElement(logIn2Btn).click();
        return new ProfilePage(driver);
    }

}
