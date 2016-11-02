package com.tests.setup;

import com.tests.domains.Application;
import com.tests.pages.Browser;
import com.tests.pages.HomePage;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UiDriverSetup {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite()
    public void suiteSetup() {
        startBrowser();
    }

    @BeforeScenario
    public void setup() throws InterruptedException {
        navigateToBaseUrl();
        assertThat("User should be on home page", new HomePage().isReady(), is(true));
    }


    public void startBrowser() {
        getBrowserDriver();
        navigateToBaseUrl();
    }

    private void navigateToBaseUrl() {
        String baseUrl = new Application().getUrl();
        new Browser().navigateTo(baseUrl);
    }

    private void getBrowserDriver() {
        System.out.println("====>>>> clear cache value: " + Browser.clear_cache);
        driver = DriverFactory.createDriver(Browser.browserName, Browser.clear_cache);
        if (Browser.clear_cache) {
            driver.manage().deleteAllCookies();
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
        driver.quit();
        driver = null;
    }
}
