package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.DetailsPage;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DetailsSteps {
    Page page;
    DetailsPage detailsPage;

    public DetailsSteps(Page page) {
        this.page = page;
        this.detailsPage = new DetailsPage(page);
    }

    @Step("Validate user is landed on detail's page")
    public DetailsSteps validateUserIsLandedOnDetailsPage() {
        assertThat(detailsPage.cartButton).isVisible();
        return this;
    }

    @Step("Validate product name is displayed")
    public DetailsSteps validateProductNameIsDisplayed() {
        assertThat(detailsPage.productName).isVisible();
        return this;
    }

    @Step("Validate product price is displayed")
    public DetailsSteps validateProductPriceIsDisplayed() {
        assertThat(detailsPage.productPrice).isVisible();
        return this;
    }

    @Step("Validate product category is displayed")
    public DetailsSteps validateProductCategoryIsDisplayed() {
        assertThat(detailsPage.productCategory).isVisible();
        return this;
    }

    @Step("Validate product brand is displayed")
    public DetailsSteps validateProductBrandIsDisplayed() {
        assertThat(detailsPage.productBrand).isVisible();
        return this;
    }

    @Step("Verify 'write your review' is displayed")
    public DetailsSteps verifyWriteYourReviewIsVisible()
    {
        assertThat(detailsPage.writeYourReview).isVisible();
        return this;
    }

    @Step("Enter name: {name}")
    public DetailsSteps enterName(String name)
    {
        detailsPage.name.fill(name);
        return this;
    }

    @Step("Enter email {email}")
    public DetailsSteps enterEmail(String email)
    {
        detailsPage.email.fill(email);
        return this;
    }

    @Step("Enter review {review}")
    public DetailsSteps enterReview(String review)
    {
        detailsPage.review.fill(review);
        return this;
    }

    @Step("Click submit button")
    public DetailsSteps clickSubmitButton()
    {
        detailsPage.submitButton.click();
        return this;
    }

    @Step("Verify success message")
    public DetailsSteps verifySuccessMessageIsVisible()
    {
        assertThat(detailsPage.successMessage).isVisible();
        return this;
    }
}
