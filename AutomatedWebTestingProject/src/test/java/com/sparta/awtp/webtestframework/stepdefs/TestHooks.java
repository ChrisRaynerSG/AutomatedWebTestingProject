package com.sparta.awtp.webtestframework.stepdefs;

import com.sparta.awtp.webtestframework.TestSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestHooks {

    @Before
    public static void setup() throws Exception {
        TestSetup.startChromeService();
        TestSetup.createWebDriver();
    }

    @After
    public static void teardown() {
        TestSetup.quitWebDriver();
        TestSetup.stopService();
    }
}
