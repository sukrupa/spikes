package org.sukrupa.schooladmin;

import org.sukrupa.schooladmin.pages.HomePage;
import org.sukrupa.schooladmin.pages.LogoutPage;

import net.sf.sahi.client.Browser;
import net.sf.sahi.client.ElementStub;

public class Page {
    public static Browser browser;

    // These 2 are placed here just for convenience.
    public static final String admin = "admin123";
    public static final String password = "krusat1324";
    public static final String baseURL = "http://staging.school.sukrupa.org";

    public Page(Browser _browser) {
        browser = _browser;
    }

    public HomePage doLogin(String username, String password) {
        enterText("j_username", username);
        enterText("j_password", password, true);
        clickButton("loginButton", true);

        return new HomePage(browser);
    }

    public LogoutPage doLogout() {
        clickLink("Logout");
        return new LogoutPage(browser);
    }
    
    public void enterText(String field, String value) {
        enterText(field, value, false);
    }

    public void enterText(String field, String value, boolean isPassword) {
        log("Setting " + field + ": " + value);
        if (isPassword) {
            browser.password(field).setValue(value);
        } else {
            browser.textbox(field).setValue(value);
        }
    }

    public void clickButton(String buttonId) {
        clickButton(buttonId, false);
    }

    public void clickButton(String buttonId, boolean isSubmit) {
        log("Clicking button: " + buttonId);
        if (isSubmit) {
            browser.submit(buttonId).click();
        } else {
            browser.button(buttonId).click();
        }
    }

    public void clickLink(String link) {
        log("Clicking link: " + link);
        browser.link(link).click();
    }

    public boolean isLoggedIn() {
        return isVisible(browser.link("Logout"));
    }
    
    public boolean isVisible(ElementStub e) {
    	return e.isVisible();
    }

    public boolean isLoggedOut() {
        return browser.containsText(browser.div("basicBody"), "You are logged out.");
    }

	protected void log(String logText) {
		System.out.println("\t\t" + logText);
	}
}
