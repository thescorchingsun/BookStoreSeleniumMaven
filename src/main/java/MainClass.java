import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MainClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Testing programs/ChromeDriver/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

    }
}
