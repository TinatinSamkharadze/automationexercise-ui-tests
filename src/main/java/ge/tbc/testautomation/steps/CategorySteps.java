package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import ge.tbc.testautomation.pages.CategoryPage;

public class CategorySteps {

    Page page;
    CategoryPage categoryPage;

    public CategorySteps(Page page) {
        this.page = page;
        categoryPage = new CategoryPage(page);
    }

    public CategorySteps verifyCategoryTitle(String expectedTitle) {
        PlaywrightAssertions.assertThat(categoryPage.getTitle(expectedTitle)).isVisible();
        return this;
    }

    public CategorySteps clickMenCategory() {
        categoryPage.kidCategory.scrollIntoViewIfNeeded();
        categoryPage.kidCategory.click();
        return this;
    }

    public CategorySteps clickJeansCategory() {
        categoryPage.topsCategory.click();
        return this;
    }

    public CategorySteps verifyEachProductContainsExpectedTitle(String expectedTitle) {
        int count = categoryPage.products.count();
        for (int i = 0; i < count; i++) {
            PlaywrightAssertions.assertThat(categoryPage.products.nth(i))
                    .containsText(expectedTitle);
        }
        return this;
    }

}
