package steps.booking;

import com.tests.domains.enums.FilterType;
import com.tests.domains.enums.ProfessionType;
import com.tests.domains.enums.SalonServiceType;
import com.tests.pages.HomePage;
import com.tests.pages.DoctorSearchResultPage;
import com.tests.pages.SalonSearchResultPage;
import com.thoughtworks.gauge.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;

public class BookingSteps {
    @Step("Select doctor by Homeopath profession")
    public void selectHomeopath() throws InterruptedException {
        DoctorSearchResultPage resultPage = new HomePage()
                .viewDoctorsTab()
                .select(ProfessionType.Homeopath);
        assertThat("SearchSteps results page should be displayed", resultPage.isReady(), is(true));
    }

    @Step("Select spas")
    public void selectSpa() throws InterruptedException {
        SalonSearchResultPage resultPage = new HomePage()
                .viewSpaAndSalonsTab()
                .select(SalonServiceType.SPA);
        assertThat("SearchSteps results page should be displayed", resultPage.isReady(), is(true));
    }

    @Step("Filter by gender <gender>")
    public void filterGender(String gender) throws InterruptedException {
        new SalonSearchResultPage().applyFilter(FilterType.GENDER, gender);
        assertThat("Gender should be checked for "+gender, new SalonSearchResultPage().getCheckedFilterValues(), contains(gender));
    }
}
