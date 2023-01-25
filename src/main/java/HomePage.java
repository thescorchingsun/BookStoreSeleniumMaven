import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By homeBanner = By.xpath("//div[@class='home-banner']");


    public HomePage DisplayBanner() {
        driver.findElement(homeBanner).isDisplayed();
        return this;
    }


}
