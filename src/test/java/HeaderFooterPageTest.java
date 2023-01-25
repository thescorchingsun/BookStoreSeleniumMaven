import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class HeaderFooterPageTest{
    private WebDriver driver;
    private HeaderFooterPage headerFooterPage;
    private HomePage homePage;
    private KatalonPage katalonPage;
    String URL_BOOKS = "https://demoqa.com/books";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Testing programs/ChromeDriver/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        headerFooterPage = new HeaderFooterPage(driver);
        homePage = new HomePage(driver);
        katalonPage = new KatalonPage(driver);
    }

    @Test (priority = 1)
    @Ignore
    public void clickToolsQALinkTest() {
        driver.get(URL_BOOKS);
        HomePage homePage = headerFooterPage.clickToolsQALink();
        HomePage banner = homePage.DisplayBanner();
        Assert.assertEquals(banner, true);
    }

    @Test (priority = 2)
    @Ignore
    public void clickKatalonLink() throws InterruptedException {
        driver.get(URL_BOOKS);
        KatalonPage katalonPage = headerFooterPage.clickKatalonLink();
        Thread.sleep(50000);
        String text1 = katalonPage.GetText();
        Assert.assertEquals(text1,"Functional web, API, mobile, and desktop apps are always a customer favorite.");
    }

    @Test (priority = 3)
    public void getFooterTextTest() {
        driver.get(URL_BOOKS);
        String footerText = headerFooterPage.GetFooterText();
        Assert.assertEquals(footerText, "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}


