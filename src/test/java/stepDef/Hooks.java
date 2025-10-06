package stepDef;

import io.cucumber.java.*;

import static helper.Utility.quitDriver;
import static helper.Utility.startDriver;

public class Hooks {
    @BeforeAll
    public static void setUp() {

    }

    @AfterAll
    public static void tearDown() {

    }

    private static final String WEB_TAG = "@web";

    @Before
    public void beforeTest(Scenario scenario) {
        // hanya jalankan browser kalau scenario punya tag @web
        if (scenario.getSourceTagNames().contains(WEB_TAG)) {
            startDriver();
        }
    }

    @After
    public void afterTest() throws InterruptedException {
        Thread.sleep(3000);
        quitDriver();
    }
}