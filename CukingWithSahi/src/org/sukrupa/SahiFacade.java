package org.sukrupa;

import cuke4duke.annotation.After;
import net.sf.sahi.client.Browser;
import net.sf.sahi.config.Configuration;

public class SahiFacade {

    private Browser browser;
    private String browserName;

    public Browser getBrowser() {
        if (browser == null) {
            // Sets up configuration for proxy. Sets Controller to java mode.
            Configuration.initJava(SahiConfiguration.SAHI_BASE, SahiConfiguration.SAHI_USERDATA);

            // Create a browser and open it
            browser = new Browser(SahiConfiguration.BROWSER_PATH, SahiConfiguration.BROWSER_PROCESS,
                    SahiConfiguration.BROWSER_OPTIONS);
            browser.open();
        }
        return browser;
    }

    @After
    public void closeBrowser() {
        if (browser != null) {
            browser.close();
            browser.kill();
        }
    }
}
