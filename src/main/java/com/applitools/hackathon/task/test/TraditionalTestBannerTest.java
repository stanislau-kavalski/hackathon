package com.applitools.hackathon.task.test;

import com.applitools.hackathon.task.assertion.WebElementAssert;
import com.applitools.hackathon.task.driver.DriverProvider;
import com.applitools.hackathon.task.page.MainPage;
import com.applitools.hackathon.task.utils.PropertiesProvider;

import org.junit.Test;

/**
 * Task 5.
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/13/2019
 *
 * @author Stanislau Kavalski
 */
public class TraditionalTestBannerTest extends TraditionalBaseTest {
    @Test
    public void task5() {
        DriverProvider.getDriver().get(PropertiesProvider.getDynamicAppUrl());
        tryLogin("login", "password");

        MainPage mainPage = new MainPage();
        WebElementAssert.assertThat(mainPage.getBanner("flashSale")).hasImage().imageIsAnimated();
        WebElementAssert.assertThat(mainPage.getBanner("flashSale2")).hasImage().imageIsAnimated();
    }
}
