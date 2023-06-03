package starter.wikipedia;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.SingleBrowser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.concurrent.TimeUnit;

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
    private final String expectedUrlAfterLogin = "https://www.saucedemo.com/inventory.html";

    @Test
    void loginPageValid() {
        driver.manage().window().maximize();
        navigate.toTheHomePage();
        /*search.searchBy("Vysoké Tatry");
        Serenity.reportThat("The first heading should be 'Mount Everest'",
                () -> assertThat(displayedArticle.getFirstHeading()).isEqualTo("Mount Everest")
        );*/
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        /*actions.sendKeysUsername("standard_user");
        actions.sendKeysPassword("secret_sauce");
        actions.clickLoginButton();*/
        Assertions.assertEquals(expectedUrlAfterLogin,driver.getCurrentUrl());
        // login successful




        /*driver.findElement(By.xpath("//input[@value='Login']")).click();
        String errorMessage = driver.findElement(By.xpath(".error-message-container error")).getText();
        //assertThat() ("Epic sadface: Username is required", errorMessage);*/
    }

}
