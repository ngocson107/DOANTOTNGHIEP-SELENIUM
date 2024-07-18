package Commons;

import DATN.COM.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseSetUp {
    public WebDriver driver;

    @BeforeMethod
    public void ChromeDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        //Khởi tạo WebUI class để nhận giá trị driver cho biến toàn cục
        new WebUI(driver);
    }
    
//    public void FirefoxDriver() {
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//
//        //Khởi tạo WebUI class để nhận giá trị driver cho biến toàn cục
//        new WebUI(driver);
//    }

//    public void EdgeDriver() {
//        driver = new EdgeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//
//        //Khởi tạo WebUI class để nhận giá trị driver cho biến toàn cục
//        new WebUI(driver);
//    }

    @AfterMethod
    public void closeDriver() {
        sleep(1);
        driver.quit();
    }

    public void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

