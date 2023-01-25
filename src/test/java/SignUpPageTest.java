import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class SignUpPageTest {

    private WebDriver driver;
    private SignUpPage signUpPage;
    String URL = "https://demoqa.com/register";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Testing programs/ChromeDriver/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        signUpPage = new SignUpPage(driver);
    }

    @Test (priority = 1)
    public void clickBackToLoginBtnTest() {
        driver.get(URL);
        LogInPage logInPage = signUpPage.ClickBackToLogIn();
        String headingH2 = logInPage.GetH2Text();
        Assert.assertEquals(headingH2, "Welcome,");
        String headingH5 = logInPage.GetH5Text();
        Assert.assertEquals(headingH5, "Login in Book Store");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
