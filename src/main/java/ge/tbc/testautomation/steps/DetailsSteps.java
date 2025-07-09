package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.DetailsPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DetailsSteps {
    Page page;
    DetailsPage detailsPage;

    public DetailsSteps(Page page) {
        this.page = page;
        this.detailsPage = new DetailsPage(page);
    }

    public DetailsSteps validateUserIsLandedOnDetailsPage() {
        assertThat(detailsPage.cartButton).isVisible();
        return this;
    }

    public DetailsSteps validateProductNameIsDisplayed() {
        assertThat(detailsPage.productName).isVisible();
        return this;
    }

    public DetailsSteps validateProductPriceIsDisplayed() {
        assertThat(detailsPage.productPrice).isVisible();
        return this;
    }

    public DetailsSteps validateProductCategoryIsDisplayed() {
        assertThat(detailsPage.productCategory).isVisible();
        return this;
    }

    public DetailsSteps validateProductBrandIsDisplayed() {
        assertThat(detailsPage.productBrand).isVisible();
        return this;
    }
}
