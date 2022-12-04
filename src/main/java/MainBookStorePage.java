import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainBookStorePage {
    private WebDriver driver;

    public MainBookStorePage(WebDriver driver) {
        this.driver = driver;
    }

    private By logInBtn = By.id("login");

    public LoginPage clickLogin() {
        driver.findElement(logInBtn).click();
        return new LoginPage(driver);
    }




}
