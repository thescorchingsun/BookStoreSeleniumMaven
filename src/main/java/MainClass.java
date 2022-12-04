import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Testing programs/ChromeDriver/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();



        driver.manage().window().maximize();
       // driver.manage().window().setSize(new Dimension(900,500));
       // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.get("https://demoqa.com/books");
        driver.get("https://www.selenium.dev/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();



    }


}
