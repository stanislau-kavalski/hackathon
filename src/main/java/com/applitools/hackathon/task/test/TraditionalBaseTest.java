package com.applitools.hackathon.task.test;

import com.applitools.hackathon.task.assertion.SoftAssert;
import com.applitools.hackathon.task.assertion.WebElementAssert;
import com.applitools.hackathon.task.driver.DriverProvider;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;

/**
 * Provides basic functionality for traditional tests.
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/12/2019
 *
 * @author Stanislau Kavalski
 */
public abstract class TraditionalBaseTest extends CommonTest{

    @Before
    public void initTest() {
        SoftAssert.reset();
    }

    @After
    public void afterTest() {
        WebElementAssert.assertAll();
    }

    @AfterClass
    public static void shutDown() {
        DriverProvider.quit();
    }

}
