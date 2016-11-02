package com.tests.pages;

import com.tests.helpers.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    @FindBy(id="doctorTab")
    private WebElement doctorTab;

    @FindBy(css="li[data-tab='Spa and Salons ']")
    private WebElement salonTab;

    public HomePage() {
        initElements(this);
    }

    public boolean isReady() throws InterruptedException {
        waitForPageLoad();
        return isElementDisplayed(doctorTab, "Doctors tab");
    }

    public DoctorsTabPage viewDoctorsTab() throws InterruptedException {
        click(doctorTab, "Doctors tab");
        return new DoctorsTabPage();
    }

    public SalonsTabPage viewSpaAndSalonsTab() throws InterruptedException {
        click(salonTab, "Salon tab");
        return new SalonsTabPage();
    }
}
