import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private By logOutBtn = By.id("submit");
    private By gotoBookStoreBtn = By.id("gotoStore");

    public MainBookStorePage clickGotoBookStore() {
        driver.findElement(gotoBookStoreBtn).click();
        return new MainBookStorePage(driver);
    }

    public LoginPage clickLogOutBtn() {
        driver.findElement(logOutBtn).click();
        return new LoginPage(driver);
    }






}
