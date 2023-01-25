import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderFooterPage {
    private WebDriver driver;

    public HeaderFooterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By toolsQALink =By.xpath("//header/a[@href='https://demoqa.com']");
    private By katalonLink = By.id("Katalon");
    private By footerText = By.xpath("//footer/span");

    public HomePage clickToolsQALink() {
        driver.findElement(toolsQALink).click();
        return new HomePage(driver);
    }

    public KatalonPage clickKatalonLink() {
        driver.findElement(katalonLink).click();
        return new KatalonPage(driver);
    }

    public String GetFooterText() {
        return driver.findElement(footerText).getText();
    }

}
