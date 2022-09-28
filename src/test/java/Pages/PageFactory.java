package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    private ProductSearch productSearch;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public ProductSearch getProductSearch() {
        if (productSearch == null) {
            productSearch = new ProductSearch(driver);
        }
        return productSearch;
    }
}
