package com.tests.pages;

import com.tests.domains.enums.ProfessionType;
import com.tests.helpers.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DoctorsTabPage extends Page {

    @FindBy(className = "speciality-icons")
    private List<WebElement> allIcons;

    public DoctorsTabPage(){
        initElements(this);
    }

    public DoctorSearchResultPage select(ProfessionType professionType) throws InterruptedException {
        String attributeName = "data-speciality";
        WebElement element = findElementWithAttributeFromList(allIcons, attributeName, professionType.toString());
        click(element, "Element with attribute "+attributeName+" as "+ professionType.toString());
        return new DoctorSearchResultPage();
    }
}
