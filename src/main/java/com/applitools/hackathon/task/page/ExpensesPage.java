package com.applitools.hackathon.task.page;

import com.applitools.hackathon.task.driver.DriverProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * Expenses page.
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/13/2019
 *
 * @author Stanislau Kavalski
 */
public class ExpensesPage extends BasePage{
    public Long getNumberOfYears() {
        return (Long)((JavascriptExecutor) DriverProvider.getDriver())
            .executeScript("return window.myBar.data.datasets.length");
    }

    public List<Long> getCharts(int index) {
        return (ArrayList<Long>)((JavascriptExecutor) DriverProvider.getDriver())
            .executeScript("return window.myBar.data.datasets[arguments[0]].data", index);
    }

    public void showNextYear() {
        findElement(By.id("addDataset")).click();
    }
}
