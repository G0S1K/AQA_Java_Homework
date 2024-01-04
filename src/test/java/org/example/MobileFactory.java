package org.example;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileFactory {
    public static AndroidDriver getAndroidDriver() {
        try {
            URL url = new URL("http://localhost:4723/wd/hub");
            return new AndroidDriver(url, MobileCapabilities.getCapabilities());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
