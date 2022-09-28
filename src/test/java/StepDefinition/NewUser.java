package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class NewUser extends BaseClass {
    @Given("Navigate to website URL")
    public void navigate_to_website_url() throws IOException {
        Setup();
        pageFactory.getProductSearch().WebsiteURL();
    }

    @When("user is on home page and click on register")
    public void user_is_on_home_page_and_click_on_register() {
        pageFactory.getNewUserInformation().Register();
    }

    @When("Fill the user infornation")
    public void fill_the_user_infornation() {
        pageFactory.getNewUserInformation().UserInformation();

    }

    @Then("Verify the user and close the browser")
    public void verify_the_user_and_close_the_browser() {
        pageFactory.getNewUserInformation().VerifyNewUser();

    }

}
