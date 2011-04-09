package org.sukrupa.schooladmin.steps;

import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.When;
import cuke4duke.annotation.I18n.EN.Then;
import org.sukrupa.schooladmin.On;
import org.sukrupa.schooladmin.pages.LoginPage;
import static org.junit.Assert.assertEquals;

public class LoginPageSteps extends BaseSteps {

    private LoginPage loginPage;

    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() {
        loginPage = On.loginPage();
    }
    
    @Given("^I am logged in$")
    public void iAmLoggedIn() {
        iAmOnTheLoginPage();
        iLogInWith("admin", "password");
    }

    @When("^I log in using \"([^\"]*)\" and \"([^\"]+)\"$")
    public void iLogInWith(String username, String password) {
        loginPage.doLogin(username, password);
    }

    @Then("^I should receive an error \"([^\"]+)\"$")
    public void iShouldReceiveAnError(String errorText) {
        String loginErrorText = loginPage.getErrorText();
        assertEquals(errorText, loginErrorText);
    }

    @When("I click on the \"Logout\" link")
    public void iClickOnTheLogoutLink() {
        loginPage.doLogout().isLoggedOut();
    }

    @Then("^I should be logged in$")
    public void iShouldBeLoggedIn() {
        boolean isLoggedIn = loginPage.isLoggedIn();
        assertEquals(isLoggedIn, true);
    }

    @Then("^I should be logged out$")
    public void iShouldBeLoggedOut() {
        assertEquals(loginPage.isLoggedOut(), true);
    }
}
