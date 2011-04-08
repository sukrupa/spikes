package org.sukrupa;

import cuke4duke.annotation.I18n;
import net.sf.sahi.client.Browser;

public class Page {
    protected Browser browser;

    public Page(Browser browser) {
        this.browser = browser;
    }

    public void enterText(String field, String value) {
        enterText(field, value, false);
    }

    public void enterText(String field, String value, boolean isPassword) {
        System.out.println("Setting " + field + ": " + value);
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
        System.out.println("Clicking button: " + buttonId);
        if (isSubmit) {
            browser.submit(buttonId).click();
        } else {
            browser.button(buttonId).click();
        }
    }

    public void clickLink(String link) {
        System.out.println("Clicking link: " + link);
        browser.link(link).click();
    }

    public boolean isLoggedIn() {
        return browser.link("Logout").isVisible();
    }

    public boolean isLoggedOut() {
        return browser.containsText(browser.div("basicBody"), "You are logged out.");
    }

}
