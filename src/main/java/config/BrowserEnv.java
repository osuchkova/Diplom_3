package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public enum BrowserEnv {
    CHROME("chrome"), YANDEX("yandex");
    private final String browser;

    BrowserEnv(String browserName) {
        this.browser = browserName;
    }

    public WebDriver getDriver() {
        switch (this) {
            case CHROME:
                return new ChromeDriver();
            case YANDEX: {
                ChromeOptions options = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
                options.setBinary("C:\\Users\\AlexK\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                return new ChromeDriver(options);
            }
            default:
                break;
        }
        return null;
    }
}
