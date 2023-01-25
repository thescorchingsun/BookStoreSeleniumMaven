import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookPage {
    private WebDriver driver;

    public BookPage(WebDriver driver) {
        this.driver = driver;
    }

    private By logInBtnMainPage = By.id("login");
    private By logOutBtn = By.xpath("//div/button[@id='submit']");
    private By SearchInput = By.xpath("//div/input[@id='searchBox']");
    private By Book4 = By.xpath("//div[4]/div/div/div/span/a[text()='Speaking JavaScript']");

    public LogInPage clickLogInOnMainPage() {
        driver.findElement(logInBtnMainPage).click();
        return new LogInPage(driver);
    }

    public LogInPage clickLogOutBtn() {
        driver.findElement(logOutBtn).click();
        return new LogInPage(driver);
    }


}
