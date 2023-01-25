import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KatalonPage {
    private WebDriver driver;

    public KatalonPage(WebDriver driver) {
        this.driver = driver;
    }

    private By Text = By.xpath("//div/div/div[@class='heading-description']/text()");
    private By katalonLogo = By.xpath("//div/div/a[@class='katalon_logo']/img");

    public String GetText() {
        return driver.findElement(Text).getText();
    }

    public KatalonPage DisplayKatalonLogo() {
        driver.findElement(katalonLogo).isDisplayed();
        return this;
    }

}
