package ge.tbc.testautomation;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.*;

@Epic("Product Functionality")
@Feature("Product Browsing and Interaction")
public class ProductFunctionalityTests extends BaseTest {

    @Test(groups={"[კატეგორიის პროდუქტების შესაბამისობა – (SCRUM-T36)]"})
    @Story("Category Navigation")
    @Description("Verify that user can navigate through Women > Dress and Men > Jeans categories, and correct titles and products are displayed.")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "Test Case", url = "https://www.automationexercise.com/")
    public void viewCategoryTest() {
        homeSteps
                .verifyCategoriesAreVisible()
                .clickOnWomenCategory()
                .clickOnDressCategory();
        categorySteps
                .verifyCategoryTitle(WOMEN_SUBCATEGORY_TITLE)
                .clickMenCategory()
                .clickJeansCategory()
                .verifyCategoryTitle(MEN_SUBCATEGORY_TITLE)
                .verifyEachProductContainsExpectedTitle(JEANS);
    }

    @Test(groups={"[პროდუქტების და პროდუქტის დეტალების გვერდი – (SCRUM-T37)]"})
    @Story("Product Detail Validation")
    @Description("Verify that product title and details are consistent between All Products page and Product Details page.")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Test Case", url = "https://www.automationexercise.com/")
    public void verifyProductTitlesAndDetailPageConsistency() {
        homeSteps
                .navigateToProductsPage();
        productsSteps
                .validateAllProductsPageIsLoaded()
                .validateProductsListIsVisible()
                .fetchFirstProductsDetails()
                .clickOnFirstProduct();
        detailsSteps
                .validateUserIsLandedOnDetailsPage()
                .validateProductNameIsDisplayed()
                .validateProductPriceIsDisplayed()
                .validateProductCategoryIsDisplayed()
                .validateProductBrandIsDisplayed();
    }

    @Test(groups={"[პროდუქტზე მიმოხილვის დამატება – (SCRUM-T38)]"})
    @Story("Product Review Submission")
    @Description("Verify that user can submit a review on the product detail page and a success message is shown.")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "Test Case", url = "https://www.automationexercise.com/")
    public void addReviewTest() {
        homeSteps
                .navigateToProductsPage();
        productsSteps
                .validateAllProductsPageIsLoaded()
                .validateProductsListIsVisible()
                .clickOnFirstProduct();
        detailsSteps
                .verifyWriteYourReviewIsVisible()
                .enterName(NAME)
                .enterEmail(EMAIL)
                .enterReview(REVIEW)
                .clickSubmitButton()
                .verifySuccessMessageIsVisible();
    }
}

