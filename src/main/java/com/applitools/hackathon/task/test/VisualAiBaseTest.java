package com.applitools.hackathon.task.test;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.hackathon.task.driver.DriverProvider;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;

/**
 * Visual AI base test.
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/13/2019
 *
 * @author Stanislau Kavalski
 */
public abstract class VisualAiBaseTest extends CommonTest {
    private static BatchInfo batch = new BatchInfo("Hackathon");

    protected EyesRunner runner;
    protected Eyes eyes;

    @AfterClass
    public static void afterAll() {
        DriverProvider.quit();
    }

    @Before
    public void beforeEach() {
        runner = new ClassicRunner();
        eyes = new Eyes(runner);
        eyes.setBatch(batch);
        eyes.setApiKey(System.getProperty("api.key"));
    }

    @After
    public void afterEach() {
        eyes.closeAsync();
    }

}
