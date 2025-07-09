package ge.tbc.testautomation;

import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.*;

public class AutomationExerciseTests extends BaseTest{

     @Test
    public void viewCategoryTest()
     {
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

     @Test
    public void verifyProductTitlesAndDetailPageConsistency()
     {
         homeSteps
                 .navigateToProductsPage();
         productsSteps
                 .validateAllProductsPageIsLoaded()
                 .validateProductsListIsVisbile()
                 .clickOnFirstProduct();
         detailsSteps
                 .validateUserIsLandedOnDetailsPage()
                 .validateProductNameIsDisplayed()
                 .validateProductPriceIsDisplayed()
                 .validateProductCategoryIsDisplayed()
                 .validateProductBrandIsDisplayed();
     }
}
