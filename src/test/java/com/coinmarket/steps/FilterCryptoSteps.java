package com.coinmarket.steps;

import com.coinmarket.pages.HomePage;
import com.coinmarket.pages.HomePageActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class FilterCryptoSteps {

    @Steps
    HomePage homePage;

    @Steps
    HomePageActions homePageActions;

    @When("the user add filter for Market Cap between {word} and {word}")
    public void the_user_add_filter_for_market_cap_between_and(String fromMCap, String toMcap) {
        homePageActions.clickFiltersButton();
        homePageActions.clickAddFiltersButton();
        homePageActions.enterMarketCapValues(fromMCap, toMcap);
    }
    @When("the user add filter for price between {int} and {int}")
    public void the_user_add_filter_for_price_between_and(Integer fromPrice, Integer toPrice) {
        homePageActions.enterPriceValues(fromPrice.toString(), toPrice.toString());
    }

    @When("the user click show results")
    public void the_user_click_show_results() {
        homePageActions.clickShowResultsButton();
    }

    @Then("verify that the page should display crypto currencies matching the criteria i.e. {word} {word} and {int} {int}")
    public void verify_that_the_page_should_display_crypto_currencies_matching_the_criteria(String fromMCap, String toMcap, Integer fromPrice, Integer toPrice) {
        homePage.verifyMarketCapRange(Double.valueOf(fromMCap), Double.valueOf(toMcap));
        homePage.verifyPriceRange(Double.valueOf(fromPrice), Double.valueOf(toPrice));
    }

}
