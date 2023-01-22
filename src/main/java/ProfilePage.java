import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private By logOutBtn = By.id("submit");
    private By gotoBookStoreBtn = By.id("gotoStore");
    private By getUserNameText = By.xpath ("//div[@id='books-wrapper']/div[3]/label[text()='Herrera9863']");

    public MainStorePage clickGotoBookStore() {
        driver.findElement(gotoBookStoreBtn).click();
        return new MainStorePage(driver);
    }

    public LogInPage clickLogOutBtn() {
        driver.findElement(logOutBtn).click();
        return new LogInPage(driver);
    }

    public String GetUserNameText() {
        return driver.findElement(getUserNameText).getText();
    }


}
