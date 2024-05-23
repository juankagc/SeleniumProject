import com.pageObjects.AccountPage;
import com.pageObjects.MainPage;
import com.pageObjects.SignUpFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected MainPage mainPage;
    protected SignUpFormPage signUpFormPage;
    protected AccountPage accountPage;

    @BeforeClass
    public void setUpDriver(){
        driver = new ChromeDriver();
        driver.get(new MainPage(driver).getUrl());
        wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofMillis(100));
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        signUpFormPage = new SignUpFormPage(driver);
        accountPage = new AccountPage(driver);
    }
    @AfterClass
    public void tearDownDriver(){
        driver.quit();
    }
}
