package org.sukrupa;

import cuke4duke.annotation.After;
import net.sf.sahi.client.Browser;
import net.sf.sahi.config.Configuration;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SahiFacade {

    private Browser browser;

    public Browser getBrowser() {
        if (browser == null) {
            String sahiBase = "c:\\devsw\\sahi"; // where Sahi is installed or unzipped
            String userDataDirectory = "c:\\devsw\\sahi\\userdata"; //path to the userdata directory
            Configuration.initJava(sahiBase, userDataDirectory); // Sets up configuration for proxy. Sets Controller to java mode.

            String browserPath = "C:\\Program Files\\Mozilla Firefox 4.0\\firefox.exe";
            String browserProcessName = "firefox.exe";
            String browserOption = "-profile " + userDataDirectory + "/browser/ff/profiles/sahi0 -no-remote";

            browserOption = browserOption.replaceAll("/", "\\\\");

            // Create a browser and open it
            browser = new Browser(browserPath, browserProcessName, browserOption);
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
