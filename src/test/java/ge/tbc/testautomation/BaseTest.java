package ge.tbc.testautomation;

import com.github.javafaker.Faker;
import com.microsoft.playwright.*;
import ge.tbc.testautomation.steps.CategorySteps;
import ge.tbc.testautomation.steps.DetailsSteps;
import ge.tbc.testautomation.steps.HomeSteps;
import ge.tbc.testautomation.steps.ProductsSteps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.Random;

import static ge.tbc.testautomation.data.Constants.AUTOMATION_EXERCISE_URL;


public class BaseTest {
    Random random = new Random();
    Faker faker = new Faker();
    SoftAssert softAssert = new SoftAssert();
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    HomeSteps homeSteps;
    CategorySteps categorySteps;
    ProductsSteps productsSteps;
    DetailsSteps detailsSteps;
    @BeforeClass
    public void setUp(){
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setArgs(Arrays.asList("--disable-gpu", "--disable-extensions", "--start-maximized"));
        launchOptions.setHeadless(false);
        browser = playwright.chromium().launch(launchOptions);
        browserContext = browser.newContext();
        page = browserContext.newPage();
        this.homeSteps = new HomeSteps(page);
        this.categorySteps = new CategorySteps(page);
        this.productsSteps = new ProductsSteps(page);
        this.detailsSteps = new DetailsSteps(page);

    }

    @AfterClass
    public void tearDown(){
        browserContext.close();
        browser.close();
        playwright.close();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpPerTest() {
        if (page == null || page.isClosed()) {
            setUp();
        }
        page.navigate(AUTOMATION_EXERCISE_URL);
    }

    @AfterMethod
    public void tearDownPerTest() {
        softAssert.assertAll();
    }
}