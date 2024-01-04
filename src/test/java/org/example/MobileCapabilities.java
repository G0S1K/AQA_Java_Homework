package org.example;

import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileCapabilities {
    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "OnePlus 9R");
        capabilities.setCapability("udid", "f9007c04");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("ignoreHiddenApiPolicyError", "true");
        return capabilities;
    }
}
