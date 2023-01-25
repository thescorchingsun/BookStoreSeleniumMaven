import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By registerBtn = By.xpath("//div/div/button[@id='register']");
    private By backToLoginBtn = By.id("gotologin");
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By userName2Field = By.id("userName");
    private By password2Field = By.id("password");
    private By recaptcha = By.xpath("//div[@id='rc-anchor-container']/div[3]/div/div/div/span/div[@class='recaptcha-checkbox-border']");
    private By hidingH4Text = By.xpath("//div/h4");
    private By TextErrorPasswordRules = By.linkText("Passwords must have at least one non alphanumeric character," +
            " one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password" +
            " must be eight characters or longer.");
    private By TextErrorRecaptcha = By.linkText("Please verify reCaptcha to register!");


    public SignUpPage ClickRegister() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div/div/button[@id='register']"))).click();
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

    public SignUpPage TypePassword (String password) throws InterruptedException {
        driver.findElement(password2Field).sendKeys(password);
        Thread.sleep(3000);
        return this;
    }

    public SignUpPage ClickRecaptcha() {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(
            "//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

    new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.elementToBeClickable(By.xpath(
            "//div[@id='rc-anchor-container']/div[3]/div/div/div/span/div[@class='recaptcha-checkbox-border']"))).click();
    return this;
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

    public SignUpPage Register(String firstname, String lastname, String username, String password) throws InterruptedException {
        this.TypeFirstName(firstname);
        this.TypeLastName(lastname);
        this.TypeUserName(username);
        this.TypePassword(password);
        this.ClickRecaptcha();
        this.ClickRegister();
        this.driver.switchTo().alert().accept();
        return this;
    }


}
