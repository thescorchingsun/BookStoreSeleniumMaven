import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class LogInPageTest {

    private WebDriver driver;
    private LogInPage logInPage;
    String URL = "https://demoqa.com/login";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Testing programs/ChromeDriver/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        logInPage = new LogInPage(driver);
    }

    @Test (priority = 1)
    public void clickNewUserBtnTest() {
        driver.get(URL);
        SignUpPage signUpPage = logInPage.clickNewUser();

        String headingH4 = signUpPage.GetTextH4();
        Assert.assertEquals(headingH4, "Register to Book Store");
    }

    @Test (priority = 2)
    public void logInWrongUsernameTest() {
        driver.get(URL);
        ProfilePage profilePage = logInPage.LogIn("Herrera","@123Qwerty");

        String errorText = logInPage.GetErrorText();
        Assert.assertEquals(errorText, "Invalid username or password!");
    }

    @Test (priority = 3)
    public void logInWrongPasswordTest() {
        driver.get(URL);
        ProfilePage profilePage = logInPage.LogIn("Herrera9863","Qwerty");

        String errorText = logInPage.GetErrorText();
        Assert.assertEquals(errorText, "Invalid username or password!");
    }

    @Test (priority = 4)
    public void logInEmptyFieldsTest() {
        driver.get(URL);
        ProfilePage profilePage = logInPage.LogIn("","");

        String headingH5 = logInPage.GetH5Text();
        Assert.assertEquals(headingH5, "Login in Book Store");
    }

    @Test (priority = 5)
    public void logInTest() {
        driver.get(URL);
        String headingH2 = logInPage.GetH2Text();
        String headingH5 = logInPage.GetH5Text();
        Assert.assertEquals(headingH2, "Welcome,");
        Assert.assertEquals(headingH5, "Login in Book Store");
        ProfilePage profilePage = logInPage.LogIn("Herrera9863","@123Qwerty");

        String userNameOnProfilePage = profilePage.GetUserNameText();
        Assert.assertEquals(userNameOnProfilePage, "Herrera9863");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
