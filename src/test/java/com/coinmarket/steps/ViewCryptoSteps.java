package com.coinmarket.steps;

import com.coinmarket.pages.HomePage;
import com.coinmarket.pages.HomePageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class ViewCryptoSteps {

    @Steps
    HomePage homePage;

    @Steps
    HomePageActions homePageActions;

    @Given("^the user visit coin market cap home page$")
    public void the_user_visit_coin_market_cap_home_page() throws NoSuchFieldException {
        homePage.open();
    }

    @When("the user select {int} from show rows dropdown")
    public void the_user_select_from_show_rows_dropdown(Integer rowsCount) {
        homePageActions.selectShowRows(rowsCount);
    }

    @Then("verify that the page should display {int} crypto currencies")
    public void verify_that_the_page_should_display_crypto_currencies(Integer expectedCount) {
        assertThat(homePage.getNumberOfCryptoCurrencyOnPage()).isEqualTo(expectedCount);

    }

}
