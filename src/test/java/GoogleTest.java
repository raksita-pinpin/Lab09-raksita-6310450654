
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class GoogleTest {


    private static WebDriver driver;
    private static WebDriverWait wait;


    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }


    @BeforeEach
    public void beforeEach() {
        driver.get("http://www.google.com");
    }


    @Test
    public void testGoogle() {
        WebElement textArea = wait.until(webDriver -> webDriver
                .findElement(By.tagName("textarea")));


        textArea.sendKeys("Kasetsart University");
        textArea.sendKeys(Keys.RETURN);;


        WebElement searchResult = wait.until(webDriver -> webDriver
                .findElement(By.tagName("h3")));


        assertEquals("มหาวิทยาลัยเกษตรศาสตร์", searchResult.getText());
    }


    @AfterEach
    public void afterEach() throws InterruptedException {
        Thread.sleep(3000);
    }


    @AfterAll
    public static void afterAll() {
        if (driver != null)
            driver.quit();
    }
}

