package org.sukrupa;

import net.sf.sahi.client.Browser;
import org.sukrupa.schooladmin.pages.LoginPage;

public class On {
    private static Browser browser = getBrowser();

    private static Browser getBrowser() {
        System.out.println("On.getBrowser");
        SahiFacade sahiFacade = new SahiFacade();
        return sahiFacade.getBrowser();
    }

    public static LoginPage loginPage() {
        if (browser == null) browser = getBrowser();
        return new LoginPage(browser);
    }
}
