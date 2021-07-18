package com.coinmarket.pages;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DefaultUrl("page:home.page")
public class HomePage extends PageObject {

    static private EnvironmentVariables environment = SystemEnvironmentVariables.createEnvironmentVariables();
    static final String HOME_PAGE_URL = EnvironmentSpecificConfiguration.from(environment)
            .getProperty("home.page");


    static final By SHOW_ROW_SELECT = By.xpath("//div[@class='sc-16r8icm-0 tu1guj-0 cSTqvK']");

    static final String ROW_SELECT_BUTTON = "//button[text()='%d']";
    static final String CC_TABLE = "//table[contains(@class,'h7vnx2-2 bFpGkc cmc-table')]/tbody";

    static final By CC_FILTERS_BUTTON = By.xpath("//button[contains(@class,'table-control-filter')]");
    static final By ADD_FILTERS_BUTTON = By.xpath("//*[@id='__next']/div/div[1]/div[2]/div/div/ul/li[5]/button");

    static final By MCAP_FILTER_BUTTON = By.xpath("//button[contains(text(),'Market Cap')]");
    static final By MCAP_FROM = By.xpath("//input[@placeholder='$0']");
    static final By MCAP_TO = By.xpath("//input[@placeholder='$999,999,999,999']");

    static final By PRICE_FILTER_BUTTON = By.xpath("//button[contains(text(),'Price')]");
    static final By PRICE_FROM = By.xpath("//input[@placeholder='$0']");
    static final By PRICE_TO = By.xpath("//input[@placeholder='$99,999']");

    static final By APPLY_FILTER_BUTTON = By.xpath("//button[contains(text(),'Apply')]");
    static final By SHOW_RESULTS_BUTTON = By.xpath("//button[contains(text(),'Show results')]");

    public int getNumberOfCryptoCurrencyOnPage(){
        return $(HomePage.CC_TABLE).findElements(net.serenitybdd.core.annotations.findby.By.tagName("tr")).size();
    }

    public void verifyMarketCapRange(Double fromMCap, Double toMCap) {
        List<Double> filteredMCap = new ArrayList<>();
        List<WebElement> rows = $(HomePage.CC_TABLE).findElements(net.serenitybdd.core.annotations.findby.By.tagName("tr"));

        //row iteration
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(net.serenitybdd.core.annotations.findby.By.tagName("td"));
            if(cols.size() > 6)
                filteredMCap.add(Double.parseDouble(cols.get(6).getText().substring(1).replaceAll(",","")));
        }

        for (Double mCap : filteredMCap) {
            assertThat(mCap >= fromMCap && mCap <= toMCap).isTrue();
        }
    }

    public void verifyPriceRange(Double fromPrice, Double toPrice) {
        List<Double> filteredPrices = new ArrayList<>();
        List<WebElement> rows = $(HomePage.CC_TABLE).findElements(net.serenitybdd.core.annotations.findby.By.tagName("tr"));

        //row iteration
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(net.serenitybdd.core.annotations.findby.By.tagName("td"));
            filteredPrices.add(Double.parseDouble(cols.get(3).getText().substring(1)));
        }

        for (Double price : filteredPrices) {
            assertThat(price >= fromPrice && price <= toPrice).isTrue();
        }
    }

}
