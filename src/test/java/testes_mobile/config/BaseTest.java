package testes_mobile.config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;
import java.net.URL;

import testes_mobile.utils.ConfigUtil;


public abstract class BaseTest {

    protected AndroidDriver driver; // Use AndroidDriver diretamente

    @BeforeEach
    public void setUp() throws MalformedURLException {
        // Configurações usando UiAutomator2Options
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(ConfigUtil.get("platformName"));
        options.setPlatformVersion(ConfigUtil.get("platformVersion"));
        options.setDeviceName(ConfigUtil.get("deviceName"));
        options.setAutomationName(ConfigUtil.get("automationName"));
        options.setAppPackage(ConfigUtil.get("appPackage"));
        options.setAppActivity(ConfigUtil.get("appActivity"));
        options.setNoReset(true);
        options.setUdid(ConfigUtil.get("deviceName"));

        URL appiumServerUrl = new URL(ConfigUtil.get("baseUrl"));

        driver = new AndroidDriver(appiumServerUrl, options);
    }

    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
