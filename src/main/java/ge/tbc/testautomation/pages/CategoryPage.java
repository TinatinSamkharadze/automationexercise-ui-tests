package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CategoryPage {
    Page page;
    public Locator title,
            kidCategory,
            topsCategory,
            products;

    public CategoryPage(Page page) {
        this.title = page.getByText("Women - Dress Products");
        this.page = page;
        this.kidCategory = page.locator("//a[@href='#Men']").first();
        this.topsCategory = page.locator("//a[@href='/category_products/6']").first();
        this.products = page.locator(".productinfo.text-center");
    }


    public Locator getTitle(String title) {
        this.title = page.getByText(title);
        return this.title;
    }


}
