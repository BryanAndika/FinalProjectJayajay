package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class Utility {

    public static WebDriver driver;

    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/helper/JSONSchema/" + JSONFile);
    }

    public static String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "+_-.";
        String email = "";

        String temp = RandomStringUtils.randomAlphanumeric(10); // Panjang email 10 karakter
        email = temp + "@testdata.com";

        return email;
    }

    public static void startDriver() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--guest");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public static void quitDriver() {
        // Memastikan driver tidak null sebelum mencoba menutupnya
        if (driver != null) {
            driver.quit();
            driver = null; // Opsional: atur kembali ke null
        }
    }
}
