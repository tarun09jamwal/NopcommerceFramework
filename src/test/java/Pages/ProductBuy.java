package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    By confirmAddress = By.xpath("//button[@class='button-1 new-address-next-step-button']");

    public ProductBuy(WebDriver driver) {
        this.driver = driver;
    }

    public void Login() {
        driver.findElement(loginlink).click();
    }

    public void LoginDetails() {
        driver.findElement(email).sendKeys("Tarun@gmail.com");
        driver.findElement(password).sendKeys("@Tarun123");
        driver.findElement(loginButton).click();
    }

    public void ProductAndAddress() {
        driver.findElement(searchBox).sendKeys("Apple MacBook Pro 13-inch");
        driver.findElement(searchButton).click();
        driver.findElement(product).click();
        driver.findElement(addToCart).click();
        driver.findElement(cart).click();
        driver.findElement(termsAndCondition).click();
        driver.findElement(checkout).click();
        driver.findElement(country).click();
        driver.findElement(city).sendKeys("Shanghai");
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
