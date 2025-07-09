package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    public Locator categoryPanel,
            womenCategory,
            dress,
            productsPage;

    public HomePage(Page page) {
        this.categoryPanel = page.locator(".col-sm-3").first();
        this.womenCategory = page.locator("//a[@href='#Women']").first();
        this.dress = page.locator("//a[@href='/category_products/1']");
        this.productsPage = page.locator("//a[@href='/products']").first();

    }
}
