package starter.wikipedia;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SearchActions extends UIInteractions {

    @Step("Search by keyword '{0}'")
    public void searchBy(String keyword) {
        $("#searchInput").sendKeys(keyword, Keys.ENTER);
    }
    @Step
    public void sendKeysUsername(String username){
        getDriver().findElement(By.id("user-name")).sendKeys(username);
    }
    @Step
    public void sendKeysPassword(String password) {
        getDriver().findElement(By.id("password")).sendKeys(password);
    }
    @Step
    public void clickLoginButton(){
        getDriver().findElement(By.id("login-button")).clear();
    }
}
