package com.applitools.hackathon.task.test;

import com.applitools.hackathon.task.driver.DriverProvider;
import com.applitools.hackathon.task.page.ExpensesPage;
import com.applitools.hackathon.task.page.MainPage;
import com.applitools.hackathon.task.utils.PropertiesProvider;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Task 4.
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/13/2019
 *
 * @author Stanislau Kavalski
 */
public class TraditionalTestCanvasChartTest extends TraditionalBaseTest {
    @Test
    public void task4() {
        DriverProvider.getDriver().get(PropertiesProvider.getAppUrl());
        tryLogin("login", "password");
        MainPage mainPage = new MainPage();
        ExpensesPage expensesPage = mainPage.openExpensesPage();
        Long numberOfYears = expensesPage.getNumberOfYears();
        Assertions.assertThat(numberOfYears).isEqualTo(2L);
        Long[] twoThousandSeventeen = new Long[]{10L, 20L, 30L, 40L, 50L, 60L, 70L};
        Long[] twoThousandEighteen = new Long[]{8L, 9L, -10L, 10L, 40L, 60L, 40L};
        Long[] twoThousandNineteen = new Long[]{5L, 10L, 15L, 20L, 25L, 30L, 35L};
        Assertions.assertThat(expensesPage.getCharts(0)).containsExactly(twoThousandSeventeen);
        Assertions.assertThat(expensesPage.getCharts(1)).containsExactly(twoThousandEighteen);
        expensesPage.showNextYear();
        Assertions.assertThat(expensesPage.getCharts(0)).containsExactly(twoThousandSeventeen);
        Assertions.assertThat(expensesPage.getCharts(1)).containsExactly(twoThousandEighteen);
        Assertions.assertThat(expensesPage.getCharts(2)).containsExactly(twoThousandNineteen);

    }
}
