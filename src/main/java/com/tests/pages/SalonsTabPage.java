package com.tests.pages;

import com.tests.domains.enums.SalonServiceType;
import com.tests.helpers.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SalonsTabPage extends Page {

    @FindBy(className = "wellness-icons")
    private List<WebElement> allIcons;

    public SalonsTabPage(){
        initElements(this);
    }

    public SalonSearchResultPage select(SalonServiceType salonServiceType) throws InterruptedException {
        String attributeName = "data-test";
        WebElement element = findElementWithAttributeFromList(allIcons, attributeName, salonServiceType.toString());
        String itemName = "Element with attribute " + attributeName + " as " + salonServiceType.toString();
        waitForElementToBeVisible(element, itemName);
        click(element, itemName);
        return new SalonSearchResultPage();
    }
}
