package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DetailsPage {
    public Locator cartButton,
            productName,
            productPrice,
            productCategory,
            productBrand,
            writeYourReview,
            name,
            email,
            review,
            submitButton,
            successMessage;
    public DetailsPage(Page page) {
        this.cartButton = page.locator(".btn.btn-default.cart").first();
        this.productName = page.locator("//div[@class='product-details']//h2");
        this.productPrice = page.locator("//div[@class='product-details']//span").last();
        this.productCategory = page.locator("//div[@class='product-details']//p").last();
        this.productBrand = page.locator("//div[@class='product-details']//b").last();
        this.writeYourReview = page.getByText("Write Your Review");
        this.name = page.locator("#name");
        this.email = page.locator("#email");
        this.review = page.locator("#review");
        this.submitButton = page.locator("#button-review");
        this.successMessage = page.getByText("Thank you for your review.");
    }
}
