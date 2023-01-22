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



    /*
    @Test
    public void registerFailTest() {
       SignUpPage signInPage1 = SignUpPage.register("Ivan","Petrov","Baburra", "@Qwerty");
       String error = signInPage.GetPasswordRulesErrorText();
       Assert.assertEquals(error,"Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
               " one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight" +
               " characters or longer.");
    }
*/








    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
