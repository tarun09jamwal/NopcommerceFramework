package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NewUserInformation {
    WebDriver driver;
    WebDriverWait wait;
    By register = By.linkText("Register");
    By genderRadio = By.xpath("//input[@id='gender-male']");
    By firstName = By.xpath("//input[@id='FirstName']");
    By lastName = By.xpath("//input[@id='LastName']");
    By dateOfBirth = By.xpath("//option[contains(text(),'27')]");
    By month = By.xpath("//option[contains(text(),'June')]");
    By year = By.xpath("//option[contains(text(),'1990')]");
    By email = By.xpath("//input[@id='Email']");
    By company = By.xpath("//input[@id='Company']");
    By password = By.xpath("//input[@id='Password']");
    By confirmPassword = By.xpath("//input[@id='ConfirmPassword']");
    By registerButton = By.xpath("//button[@id='register-button']");
    By userVerify = By.xpath("//div[contains(text(),'Your registration completed')]");

    public NewUserInformation(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void Register() {
        driver.findElement(register).click();
    }

    public void UserInformation() {
        driver.findElement(genderRadio).click();
        driver.findElement(firstName).sendKeys("Tarun");
        driver.findElement(lastName).sendKeys("Jamwal");
        driver.findElement(dateOfBirth).click();
        driver.findElement(month).click();
        driver.findElement(year).click();
        driver.findElement(email).sendKeys("Tarun@gmail.com");
        driver.findElement(company).sendKeys("Google");
        driver.findElement(password).sendKeys("@Tarun123");
        driver.findElement(confirmPassword).sendKeys("@Tarun123");
        driver.findElement(registerButton).click();
    }

    public void VerifyNewUser() {
        String actual = driver.findElement(userVerify).getText();
        Assert.isTrue(actual.equals("Your registration completed"), "Expected result does not match with actual result");
        driver.close();
    }

}
