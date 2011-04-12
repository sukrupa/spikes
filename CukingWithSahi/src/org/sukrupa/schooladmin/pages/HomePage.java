package org.sukrupa.schooladmin.pages;

import org.sukrupa.schooladmin.Page;

import net.sf.sahi.client.Browser;

public class HomePage extends Page {
    public HomePage(Browser browser) {
        super(browser);
    }
    
    public boolean isSideMenuItemVisible(String menuText) {
    	return browser.link(menuText).isVisible();
    }

    public StudentSearchPage searchStudents() {
        browser.link("Search Students").click();
        return new StudentSearchPage(browser);
    }
}
