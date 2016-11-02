package com.tests.pages;

import com.tests.domains.enums.FilterType;
import com.tests.helpers.ui.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SalonSearchResultPage extends Page {

    @FindBy(id = "filterForm")
    private WebElement filterForm;

    @FindBy(className = "labelForFilterCheckboxes")
    private List<WebElement> filterLabels;

    @FindBy(className = "listing-filters-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(css = ".listing-row .clinic-name-container h2")
    private List<WebElement> allListings;

    public SalonSearchResultPage() {
        initElements(this);
    }

    public boolean isReady() throws InterruptedException {
        return isElementDisplayed(filterForm, "Filter form");
    }

    public DetailPage selectResultAt(int rowNumber) throws InterruptedException {
        WebElement element = allListings.get(rowNumber - 1);
        String title = element.getText();
        click(element, "Listing at row " + rowNumber);
        return new DetailPage(title);
    }

    public void applyFilter(FilterType filterType, String filterValue) throws InterruptedException {
        openFilter(filterType.toString());
        WebElement label = findElementWithTextFromList(filterLabels, filterValue);
        WebElement checkbox = label.findElement(By.xpath("preceding-sibling::label[contains(@class,'checkbox')]"));
        checkbox.click();
    }

    private void openFilter(String filterId) {
        WebElement element = findElement(By.id(filterId));
        String classValue = element.getAttribute("class");
        if (!classValue.contains("open"))
            element.click();
    }

    public List<String> getCheckedFilterValues() throws InterruptedException {
        List<String> names = new ArrayList<String>();
        List<WebElement> elements = findElementsWithAttributeFromList(checkboxes, "checked", "true");
        if (elements.size() > 0)
            for (WebElement element : elements) {
                String text = element.findElement(By.xpath("following-sibling::label[@class='labelForFilterCheckboxes']")).getText();
                names.add(text);
            }
        return names;
    }
}
