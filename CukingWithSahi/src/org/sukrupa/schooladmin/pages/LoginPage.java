package org.sukrupa.schooladmin.pages;

import net.sf.sahi.client.Browser;
import org.sukrupa.Page;

public class LoginPage extends Page {
    public LoginPage(Browser browser) {
        super(browser);
        browser.navigateTo("http://localhost:8080/");
    }

    public LoginPage doLogin(String username, String password) {
        enterText("j_username", username);
        enterText("j_password", password, true);
        clickButton("loginButton", true);

        return this;
    }

    public String getErrorText() {
        return browser.div("errorMessages").text();
    }

    public LoginPage doLogout() {
        clickLink("Logout");
        return this;
    }
}
