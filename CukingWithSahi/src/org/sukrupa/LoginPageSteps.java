package org.sukrupa;

import cuke4duke.annotation.After;
import cuke4duke.annotation.I18n.EN.*;
import net.sf.sahi.client.Browser;
import org.sukrupa.schooladmin.pages.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LoginPageSteps {

    private LoginPage loginPage;
/*
    private Browser browser;

    public LoginPageSteps(SahiFacade facade) {
        browser = facade.getBrowser();
    }
*/
    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() {
        loginPage = On.loginPage();
//        browser.navigateTo("http://localhost:8080");
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
        loginPage.doLogout();
    }

    @Then("^I should be logged in$")
    public void iShouldBeLoggedIn() {
        boolean isLoggedIn = loginPage.isLoggedIn();
        loginPage.doLogout();
        assertEquals(isLoggedIn, true);
    }

    @Then("^I should be logged out$")
    public void iShouldBeLoggedOut() {
        assertEquals(loginPage.isLoggedOut(), true);
    }
}
