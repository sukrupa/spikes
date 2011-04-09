package org.sukrupa.schooladmin;

import net.sf.sahi.client.Browser;

import org.sukrupa.SahiFacade;
import org.sukrupa.schooladmin.pages.HomePage;
import org.sukrupa.schooladmin.pages.LoginPage;

public class On {
    private static Browser browser = getBrowser();

    private static Browser getBrowser() {
    	if (browser == null) {
	        System.out.println("On.getBrowser");
	        SahiFacade sahiFacade = new SahiFacade();
	        return sahiFacade.getBrowser();
    	}
    	return browser;
    }

    public static LoginPage loginPage() {
        if (browser == null) browser = getBrowser();
        return new LoginPage(browser);
    }
    
    public static HomePage homePage() {
    	return loginPage().doLogin("admin", "password");
    }
}
