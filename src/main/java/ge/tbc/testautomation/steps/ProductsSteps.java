package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.ProductsPage;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductsSteps {
    Page page;
    ProductsPage productsPage;
    String details;

    public ProductsSteps(Page page) {
        this.page = page;
        this.productsPage = new ProductsPage(page);
    }

    @Step("Validate all products page is loaded")
    public ProductsSteps validateAllProductsPageIsLoaded() {
        assertThat(productsPage.title).isVisible();
        return this;
    }

    @Step("Validate product list is visible")
    public ProductsSteps validateProductsListIsVisible() {
        assertThat(productsPage.items).isVisible();
        return this;
    }

    @Step("Fetch first product's details")
    public ProductsSteps fetchFirstProductsDetails()
    {
        details = productsPage.firstProduct.textContent();
        return this;
    }

    @Step("Click on first product")
    public ProductsSteps clickOnFirstProduct() {
        productsPage.firstProduct.click();
        return this;
    }
}
