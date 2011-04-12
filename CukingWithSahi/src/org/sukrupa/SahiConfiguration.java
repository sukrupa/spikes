package org.sukrupa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SahiConfiguration {
    private static Properties props;

    public static String OS_NAME = getOS();
    public static String SAHI_BASE = fixPath(getProperty("sahi-base"));
    public static String SAHI_USERDATA = fixPath(getProperty("sahi-userdata"));
    public static String BROWSER_PATH = fixPath(getProperty("browser-path"));
    public static String BROWSER_PROCESS = getProperty("browser-process");
    public static String BROWSER_OPTIONS = getProperty("browser-options");

    private static String getOS() {
        String osname = System.getProperty("os.name").toLowerCase();
        if (osname.toLowerCase().contains("windows")) {
            osname="windows";
        }
        return osname;
    }

    private static String fixPath(String path) {
        String fixedPath = path;
        if (OS_NAME.equals("windows")) {
            fixedPath = path.replaceAll("/", "\\\\");
        }
        return fixedPath;
    }

    private  static String getProperty(String propertyName) {
        if (props == null) {
            try {
                props = new Properties();
                props.load(new FileInputStream("test.properties"));
            } catch (FileNotFoundException fnfE) {
                fnfE.printStackTrace();
            } catch (IOException ioE) {
                ioE.printStackTrace();
            }
        }

        // Try to see if there is a property of the format osName-propertyName
        String propertyValue = props.getProperty(OS_NAME + "-" + propertyName, "NULL");

        // Else it must be osName-browserName-propertyName
        if (propertyValue.equals("NULL")) {
            String browserName = System.getProperty("sahi-browser").toLowerCase();
            propertyValue = props.getProperty(OS_NAME + "-" + browserName + "-" + propertyName);
        }

        return propertyValue;
    }
}
