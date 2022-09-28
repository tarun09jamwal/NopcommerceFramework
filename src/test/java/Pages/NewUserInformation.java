package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    public void UserInformation() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//NopCommerceUserData.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String firstname = sheet.getRow(1).getCell(0).getStringCellValue();
        String lastname = sheet.getRow(1).getCell(1).getStringCellValue();
        String userEmail = sheet.getRow(1).getCell(2).getStringCellValue();
        String userCompany = sheet.getRow(1).getCell(3).getStringCellValue();
        String userPassword = sheet.getRow(1).getCell(4).getStringCellValue();
        String userConfirmPassword = sheet.getRow(1).getCell(5).getStringCellValue();

        driver.findElement(genderRadio).click();
        driver.findElement(firstName).sendKeys(firstname);
        driver.findElement(lastName).sendKeys(lastname);
        driver.findElement(dateOfBirth).click();
        driver.findElement(month).click();
        driver.findElement(year).click();
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(company).sendKeys(userCompany);
        driver.findElement(password).sendKeys(userPassword);
        driver.findElement(confirmPassword).sendKeys(userConfirmPassword);
        driver.findElement(registerButton).click();
    }

    public void VerifyNewUser() {
        String actual = driver.findElement(userVerify).getText();
        Assert.isTrue(actual.equals("Your registration completed"), "Expected result does not match with actual result");
        driver.close();
    }

}
