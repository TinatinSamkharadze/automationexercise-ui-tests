package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import ge.tbc.testautomation.pages.HomePage;

public class HomeSteps {
    Page page;
    HomePage homePage;

    public HomeSteps(Page page) {
        this.page = page;
        this.homePage = new HomePage(page);
    }

    public HomeSteps verifyCategoriesAreVisible() {
        PlaywrightAssertions.assertThat(homePage.categoryPanel).isVisible();
        return this;
    }

    public HomeSteps clickOnWomenCategory() {

        homePage.womenCategory.scrollIntoViewIfNeeded();
        homePage.womenCategory.click();
        return this;
    }

    public HomeSteps clickOnDressCategory() {
        homePage.dress.click();
        return this;
    }

    public HomeSteps navigateToProductsPage() {
        homePage.productsPage.click();
        return this;
    }
}
