package com.tests.pages;

import com.tests.helpers.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DoctorSearchResultPage extends Page{

    @FindBy(id="filterForm")
    private WebElement filters;

    @FindBy(css = ".listing-row .doc-details-block .doc-name h2")
    private List<WebElement> allListings;

    public DoctorSearchResultPage(){
        initElements(this);
    }

    public boolean isReady() throws InterruptedException {
        return isElementDisplayed(filters, "Filter form");
    }

    public DetailPage selectResultAt(int rowNumber) throws InterruptedException {
        WebElement element = allListings.get(rowNumber-1);
        String title = element.getText();
        click(element, "Listing at row "+rowNumber);
        return new DetailPage(title);
    }
}
