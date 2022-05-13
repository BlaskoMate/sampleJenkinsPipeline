

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.IndexPage;

import java.net.MalformedURLException;
import java.net.URL;

// test
public class BaseTests {
        protected static WebDriver driver;
        protected IndexPage indexPage = new IndexPage(driver);
        protected String url;

        public BaseTests() {
            this.url = "https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa";
        }

        @BeforeAll
        public static void setChromeDriver() throws MalformedURLException {
            if (System.getProperty("os.name").equals("Linux")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            }
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("browseVersion", "96");
            chromeOptions.setCapability("platformName", "Linux");
            driver = new RemoteWebDriver(new URL("https://selenium:CCAutoTest19.@seleniumhub.codecool.metastage.net/"), chromeOptions);
            driver.manage().window().maximize();
        }

        @BeforeEach
        public void prepareTest() {
            openPage();
        }

        protected void openPage() {
            driver.get(url);
        }

        @AfterAll
        static void tearDown(){
            driver.close();
            driver.quit();
        }

        @Test
        public void asd() throws InterruptedException {
            Assertions.assertTrue(true);
        }
    }
