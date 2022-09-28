package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class ProductBuy extends BaseClass {
    @Given("User Navigates to the website URL")
    public void user_navigates_to_the_website_url() throws IOException {
        Setup();
        pageFactory.getProductSearch().WebsiteURL();
    }

    @When("user is on homepage and click on login page link")
    public void user_is_on_homepage_and_click_on_login_page_link() {
        pageFactory.getProductBuy().Login();
    }

    @When("Enter the useremail and password click login")
    public void enter_the_useremail_and_password_click_login() throws IOException {
        pageFactory.getProductBuy().LoginDetails();
    }

    @When("Search the product and checkout")
    public void search_the_product_and_checkout() throws IOException {
        pageFactory.getProductBuy().ProductAndAddress();

    }

    @Then("Verify the order and close the browser")
    public void verify_the_order_and_close_the_browser() {
        pageFactory.getProductBuy().VerifyProduct();
    }
}
