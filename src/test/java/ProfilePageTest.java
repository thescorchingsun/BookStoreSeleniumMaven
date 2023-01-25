import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class ProfilePageTest {

        private WebDriver driver;
        private ProfilePage profilePage;
        private LogInPage logInPage;
        String URL_LOGIN = "https://demoqa.com/login";

        @BeforeTest
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "C:/Testing programs/ChromeDriver/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            profilePage = new ProfilePage(driver);
            logInPage = new LogInPage(driver);
        }

        @Test(priority = 1)
        public void clickLogOutTest() {
            driver.get(URL_LOGIN);
            ProfilePage profilePage = logInPage.LogIn("Herrera9863","@123Qwerty");

            LogInPage logInPage = profilePage.clickLogOutBtn();

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

