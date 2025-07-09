package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import ge.tbc.testautomation.pages.HomePage;
import io.qameta.allure.Step;

public class HomeSteps {
    Page page;
    HomePage homePage;

    public HomeSteps(Page page) {
        this.page = page;
        this.homePage = new HomePage(page);
    }

    @Step("Verify categories are visible")
    public HomeSteps verifyCategoriesAreVisible() {
        PlaywrightAssertions.assertThat(homePage.categoryPanel).isVisible();
        return this;
    }

    @Step("Click 'Women' Category")
    public HomeSteps clickOnWomenCategory() {

        homePage.womenCategory.scrollIntoViewIfNeeded();
        homePage.womenCategory.click();
        return this;
    }

    @Step("Click 'Dress' category")
    public HomeSteps clickOnDressCategory() {
        homePage.dress.click();
        return this;
    }

    @Step("Navigate to product's page")
    public HomeSteps navigateToProductsPage() {
        homePage.productsPage.click();
        return this;
    }
}
