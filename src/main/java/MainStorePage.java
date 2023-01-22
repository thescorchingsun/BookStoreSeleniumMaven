import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainStorePage {
    private WebDriver driver;

    public MainStorePage(WebDriver driver) {
        this.driver = driver;
    }

    private By logInBtnMainPage = By.id("login");

    public LogInPage clickLogInOnMainPage() {
        driver.findElement(logInBtnMainPage).click();
        return new LogInPage(driver);
    }




}
