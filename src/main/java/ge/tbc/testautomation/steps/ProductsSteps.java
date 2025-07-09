package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.ProductsPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductsSteps {
    Page page;
    ProductsPage productsPage;

    public ProductsSteps(Page page) {
        this.page = page;
        this.productsPage = new ProductsPage(page);
    }

    public ProductsSteps validateAllProductsPageIsLoaded() {
        assertThat(productsPage.title).isVisible();
        return this;
    }

    public ProductsSteps validateProductsListIsVisbile() {
        assertThat(productsPage.items).isVisible();
        return this;
    }

    public ProductsSteps clickOnFirstProduct() {
        productsPage.firstProduct.click();
        return this;
    }
}
