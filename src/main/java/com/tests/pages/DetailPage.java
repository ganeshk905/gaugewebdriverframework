package com.tests.pages;

import com.tests.helpers.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailPage extends Page{
    String title;

    @FindBy(css="h1[itemprop='name']")
    private WebElement name;
    
    public DetailPage(String title) {
        this.title = title;
        initElements(this);
    }

    public boolean isReady() throws InterruptedException {
        waitForElementToBeVisible(name, "Name of doctor/clinic");
        return isTextPresent(name, title);
    }
}
