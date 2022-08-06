import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class GoogleFindImageTest {
    private static final String HOME_URL = "https://www.google.com/";
    public static final String SEARCH_WORD = "rose";

    @Test
    public static void main(String[] args)  {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_URL);

        WebElement element = driver.findElement(By.xpath("//input[@title]"));
        element.sendKeys(SEARCH_WORD, Keys.ENTER);

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//img[contains(@alt, 'rose')]")));
        List<WebElement> searchList = driver.findElements(By.xpath("//img[contains(@alt, 'rose')]"));

        Assert.assertTrue(searchList.size() > 0);
        System.out.println("Amount images with word 'rose' is " + searchList.size());

        driver.quit();
    }
}
