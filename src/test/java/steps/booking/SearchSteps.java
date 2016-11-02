package steps.booking;

import com.tests.pages.ClinicSearchResultPage;
import com.tests.pages.DetailPage;
import com.tests.pages.DoctorSearchResultPage;
import com.thoughtworks.gauge.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SearchSteps {
    @Step("View information of the first doctor in search result")
    public void viewDocInfo() throws InterruptedException {
        DetailPage detail = new DoctorSearchResultPage().selectResultAt(1);
        assertThat("Detail page should be shown", detail.isReady(), is(true));
    }

    @Step("View information of the first clinic in search result")
    public void viewClinicInfo() throws InterruptedException {
        DetailPage detail = new ClinicSearchResultPage().selectResultAt(1);
        assertThat("Detail page should be shown", detail.isReady(), is(true));
    }

    @Step("Search for location <location> and speciality <speciality>")
    public void search(String location, String speciality) {
        // work in progress: for demo
    }
}
