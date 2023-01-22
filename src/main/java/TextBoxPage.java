import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage {
    private WebDriver driver;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    private By fullNameField = By.id("userName");
    private By userEmailField = By.id("userEmail");
    private By currentAddressField = By.id("currentAddress");
    private By permanentAddressField = By.id("permanentAddress");
    private By submitBtn = By.id("submit");




}
