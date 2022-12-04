import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By registerBtn = By.id("register");
    private By backToLoginBtn = By.id("gotologin");
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By userName2Field = By.id("userName");
    private By password2Field = By.id("password");
    private By recaptcha = By.xpath("//div[@role='presentation']");


    public RegisterPage clickRegister() {
        driver.findElement(registerBtn).click();
        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(backToLoginBtn).click();
        return new LoginPage(driver);
    }

    public RegisterPage typeFirstName (String firstname) {
        driver.findElement(firstNameField).sendKeys(firstname);
        return this;
    }

    public RegisterPage typeLastName (String lastname) {
        driver.findElement(lastNameField).sendKeys(lastname);
        return this;
    }

    public RegisterPage typeUserName (String username) {
        driver.findElement(userName2Field).sendKeys(username);
        return this;
    }

    public RegisterPage typePassword (String password) {
        driver.findElement(password2Field).sendKeys(password);
        return this;
    }

    public RegisterPage clickRecaptcha() {
        driver.findElement(recaptcha).click();
        return this;
    }




}
