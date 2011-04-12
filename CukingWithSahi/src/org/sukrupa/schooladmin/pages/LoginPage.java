package org.sukrupa.schooladmin.pages;

import net.sf.sahi.client.Browser;

import org.sukrupa.schooladmin.Page;

public class LoginPage extends Page {
    public LoginPage(Browser browser) {
        super(browser);
        browser.navigateTo(Page.baseURL);
    }

    public String getErrorText() {
        return browser.div("errorMessages").text();
    }

}
