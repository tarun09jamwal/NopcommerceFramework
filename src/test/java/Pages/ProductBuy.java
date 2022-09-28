package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ProductBuy {
    WebDriver driver;
    By loginlink = By.linkText("Log in");
    By email = By.xpath("//input[@class='email']");
    By password = By.xpath("//input[@class='password']");
    By loginButton = By.xpath("//button[@class='button-1 login-button']");
    By searchBox = By.xpath("//input[@id='small-searchterms']");
    By searchButton = By.xpath("//button[@type='submit']");
    By product = By.linkText("Apple MacBook Pro 13-inch");
    By addToCart = By.xpath("//button[@id='add-to-cart-button-4']");
    By cart = By.xpath("//span[@class='cart-label']");
    By termsAndCondition = By.xpath("//input[@id='termsofservice']");
    By checkout = By.xpath("//button[@name='checkout']");
    By country = By.xpath("//option[contains(text(),'China')]");
    By city = By.xpath("//input[@id='BillingNewAddress_City']");
    By address = By.xpath("//input[@id='BillingNewAddress_Address1']");
    By zip = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    By phoneNumber = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
    By continueButton = By.xpath("(//button[@class='button-1 new-address-next-step-button'])[1]");
    By deliveryContinueButton = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
    By paymentContinueButton = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    By buttonContinue = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
    By confirmOrder = By.xpath("//button[@class='button-1 confirm-order-next-step-button']");
    By verifyOrder = By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]");


    public ProductBuy(WebDriver driver) {
        this.driver = driver;
    }

    public void Login() {
        driver.findElement(loginlink).click();
    }

    public void LoginDetails() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//NopCommerceUserData.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String userEmail = sheet.getRow(1).getCell(2).getStringCellValue();
        String userPassword = sheet.getRow(1).getCell(4).getStringCellValue();
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(password).sendKeys(userPassword);
        driver.findElement(loginButton).click();
    }

    public void ProductAndAddress() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//NopCommerceUserData.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String buyProduct = sheet.getRow(1).getCell(6).getStringCellValue();
        String userCity = sheet.getRow(1).getCell(7).getStringCellValue();
        driver.findElement(searchBox).sendKeys(buyProduct);
        driver.findElement(searchButton).click();
        driver.findElement(product).click();
        driver.findElement(addToCart).click();
        driver.findElement(cart).click();
        driver.findElement(termsAndCondition).click();
        driver.findElement(checkout).click();
        driver.findElement(country).click();
        driver.findElement(city).sendKeys(userCity);
        driver.findElement(address).sendKeys("H.No.-512,Chowmin Street");
        driver.findElement(zip).sendKeys("175001");
        driver.findElement(phoneNumber).sendKeys("987654321");
        driver.findElement(continueButton).click();
        driver.findElement(deliveryContinueButton).click();
        driver.findElement(paymentContinueButton).click();
        driver.findElement(buttonContinue).click();
        driver.findElement(confirmOrder).click();
    }

    public void VerifyProduct() {
        String actual = driver.findElement(verifyOrder).getText();
        Assert.isTrue(actual.equals("Your order has been successfully processed!"), "Expected result does not match with actual result");
        driver.close();
    }

}
