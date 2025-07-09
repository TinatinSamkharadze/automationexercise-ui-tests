package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductsPage {
    public Locator title,
            items,
            firstProduct;

    public ProductsPage(Page page) {
        this.title = page.getByText("All Products").first();
        this.items = page.locator(".features_items");
        this.firstProduct = page.locator("//a[@href='/product_details/1']").first();
    }
}
