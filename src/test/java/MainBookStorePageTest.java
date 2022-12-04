import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainBookStorePageTest {

    private WebDriver driver;
    private MainBookStorePage mainBookStorePage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Testing programs/ChromeDriver/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/books");
        mainBookStorePage = new MainBookStorePage(driver);
    }

    @Test
    public void login() {
        LoginPage loginPage = mainBookStorePage.clickLogin();
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
