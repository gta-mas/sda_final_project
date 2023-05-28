package starter.wikipedia;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.SingleBrowser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenSearchingForTerms {

    /**
     * Define the webdriver instance to be used for these tests
     */
    @Managed(driver = "chrome")
    WebDriver driver;

    /**
     * Navigation actions. This is a UIInteraction class so it will be instantiated automatically by Serenity.
     */
    NavigateActions navigate;

    /**
     * Actions related to searches. This is a UIInteraction class so it will be instantiated automatically by Serenity.
     */
    SearchActions search;

    /**
     * A page object representing a Wikipedia article that is currently appearing in the browser.
     * Page Objects are automatically initialised by Serenity.
     */
    DisplayedArticle displayedArticle;
    //komentár

    @Test
    void searchBySingleKeyword() throws InterruptedException {
        driver.manage().window().maximize();
        navigate.toTheHomePage();
        /*search.searchBy("Vysoké Tatry");
        Serenity.reportThat("The first heading should be 'Mount Everest'",
                () -> assertThat(displayedArticle.getFirstHeading()).isEqualTo("Mount Everest")
        );*/
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.name("user-name")).clear();
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).clear();
        Thread.sleep(2000);

        /*driver.findElement(By.xpath("//input[@value='Login']")).click();
        String errorMessage = driver.findElement(By.xpath(".error-message-container error")).getText();
        //assertThat() ("Epic sadface: Username is required", errorMessage);*/
    }

}
