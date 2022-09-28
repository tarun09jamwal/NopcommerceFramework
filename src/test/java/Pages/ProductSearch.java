package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ProductSearch {
    WebDriver driver;
    WebDriverWait wait;
    By searchBox = By.xpath("//input[@type='text']");
    By searchButton = By.xpath("//button[@type='submit']");
    By verifyProduct = By.linkText("Nokia Lumia 1020");

    public ProductSearch(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void WebsiteURL() throws IOException {
        FileReader reader = new FileReader("src/test/java/PropertiesFile/Config.properties");
        Properties data = new Properties();
        data.load(reader);
        driver.get(data.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void Product() {
        driver.findElement(searchBox).sendKeys("Nokia lumia 1020");
        driver.findElement(searchButton).click();

    }

    public void VerifyProduct() {
        String actual = driver.findElement(verifyProduct).getText();
        Assert.isTrue(actual.equals("Nokia Lumia 1020"), "Expected result does not match with actual result");
        driver.close();
    }
}
