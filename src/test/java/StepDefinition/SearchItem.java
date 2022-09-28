package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class SearchItem extends BaseClass {

    @Given("Navigate to the website URL")
    public void navigate_to_the_website_url() throws IOException {
        Setup();
        pageFactory.getProductSearch().WebsiteURL();

    }

    @When("user is on page and search the item")
    public void user_is_on_page_and_search_the_item() {
        pageFactory.getProductSearch().Product();

    }

    @Then("Verify the item page and close the browser")
    public void verify_the_item_page_and_close_the_browser() {
        pageFactory.getProductSearch().VerifyProduct();

    }

}
