package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    private ProductSearch productSearch;
    private NewUserInformation newUserInformation;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public ProductSearch getProductSearch() {
        if (productSearch == null) {
            productSearch = new ProductSearch(driver);
        }
        return productSearch;
    }

    public NewUserInformation getNewUserInformation() {
        if (newUserInformation == null) {
            newUserInformation = new NewUserInformation(driver);
        }
        return newUserInformation;
    }
}
