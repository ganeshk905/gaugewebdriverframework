package com.tests.pages;

import com.tests.helpers.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ClinicSearchResultPage extends Page{

    @FindBy(id="filterForm")
    private WebElement filtersForm;

    @FindBy(css = ".listing-row .clinic-name-container .doc-name h2")
    private List<WebElement> allListings;

    public ClinicSearchResultPage(){
        initElements(this);
    }

    public boolean isReady() throws InterruptedException {
        return isElementDisplayed(filtersForm, "Filter form");
    }

    public DetailPage selectResultAt(int rowNumber) throws InterruptedException {
        WebElement element = allListings.get(rowNumber-1);
        String title = element.getText();
        click(element, "Listing at row "+rowNumber);
        return new DetailPage(title);
    }
}
