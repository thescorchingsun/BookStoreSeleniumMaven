import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By registerBtn = By.id("register");
    private By backToLoginBtn = By.id("gotologin");
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By userName2Field = By.id("userName");
    private By password2Field = By.id("password");
    private By recaptcha = By.xpath("//div[@role='presentation']");
    private By hidingH4Text = By.xpath("//div/h4");
    private By TextErrorPasswordRules = By.linkText("Passwords must have at least one non alphanumeric character," +
            " one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password" +
            " must be eight characters or longer.");
    private By TextErrorRecaptcha = By.linkText("Please verify reCaptcha to register!");



    public SignUpPage ClickRegister() {
        driver.findElement(registerBtn).click();
        return this;
    }

    public LogInPage ClickBackToLogIn() {
        driver.findElement(backToLoginBtn).click();
        return new LogInPage(driver);
    }

    public SignUpPage TypeFirstName (String firstname) {
        driver.findElement(firstNameField).sendKeys(firstname);
        return this;
    }

    public SignUpPage TypeLastName (String lastname) {
        driver.findElement(lastNameField).sendKeys(lastname);
        return this;
    }

    public SignUpPage TypeUserName (String username) {
        driver.findElement(userName2Field).sendKeys(username);
        return this;
    }

    public SignUpPage TypePassword (String password) {
        driver.findElement(password2Field).sendKeys(password);
        return this;
    }

    public SignUpPage ClickClickCheckbox () {
        driver.findElement(recaptcha).click();
        return new SignUpPage(driver);
    }

    public String GetTextH4() {
        return driver.findElement(hidingH4Text).getText();
    }

    public String GetPasswordRulesErrorText() {
        return driver.findElement(TextErrorPasswordRules).getText();
    }

    public String GetRecaptchaErrorText() {
        return driver.findElement(TextErrorRecaptcha).getText();
    }

/*
    public static SignInPage Register(String firstname, String lastname, String username, String password) {
        this.TypeFirstName(firstname);
        this.TypeLastName(lastname);
        this.TypeUserName(username);
        this.TypePassword(password);
        driver.findElement(recaptcha).click();
        driver.findElement(registerBtn).click();
        return new SignInPage(driver);
    }

*/




}
