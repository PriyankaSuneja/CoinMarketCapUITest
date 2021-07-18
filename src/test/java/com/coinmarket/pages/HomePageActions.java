package com.coinmarket.pages;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class HomePageActions extends UIInteractionSteps {

    @Step
    public void selectShowRows(int rowsCount) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        WebElement element = $(HomePage.SHOW_ROW_SELECT);
        jsExecutor.executeScript("arguments[0].click();", element);

        WebElement selectRowButton = getDriver().findElement(By.xpath(String.format(HomePage.ROW_SELECT_BUTTON,rowsCount)));
        selectRowButton.click();
    }

    @Step
    public void clickFiltersButton() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        WebElement element = $(HomePage.CC_FILTERS_BUTTON);
        js.executeScript("arguments[0].click();", element);
    }

    @Step
    public void clickAddFiltersButton() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        WebElement element = $(HomePage.ADD_FILTERS_BUTTON);
        js.executeScript("arguments[0].click();", element);
    }

    @Step
    public void enterMarketCapValues(String fromValue, String toValue) {

        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        WebElement mCapElement = $(HomePage.MCAP_FILTER_BUTTON);
        js.executeScript("arguments[0].click();", mCapElement);

        $(HomePage.MCAP_FROM).sendKeys(fromValue);
        $(HomePage.MCAP_TO).sendKeys(toValue);
        clickApplyButton();
    }

    @Step
    public void enterPriceValues(String fromValue, String toValue) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        WebElement priceElement = $(HomePage.PRICE_FILTER_BUTTON);
        js.executeScript("arguments[0].click();", priceElement);

        $(HomePage.PRICE_FROM).sendKeys(fromValue);
        $(HomePage.PRICE_TO).sendKeys(toValue);
        clickApplyButton();
    }

    @Step
    private void clickApplyButton() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        WebElement element = $(HomePage.APPLY_FILTER_BUTTON);
        js.executeScript("arguments[0].click();", element);
    }

    @Step
    public void clickShowResultsButton() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        WebElement element = $(HomePage.SHOW_RESULTS_BUTTON);
        js.executeScript("arguments[0].click();", element);
    }
}
