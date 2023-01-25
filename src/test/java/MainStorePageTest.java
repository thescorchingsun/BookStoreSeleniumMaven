import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class MainStorePageTest {

    private WebDriver driver;
    private BookPage mainStorePage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Testing programs/ChromeDriver/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/books");
        mainStorePage = new BookPage(driver);
    }

    @Test
    public void loginTest() {
        LogInPage loginPage = mainStorePage.clickLogInOnMainPage();
        String headingH2 = loginPage.GetH2Text();
        String headingH5 = loginPage.GetH5Text();
        Assert.assertEquals(headingH2, "Welcome,");
        Assert.assertEquals(headingH5, "Login in Book Store");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }




}
