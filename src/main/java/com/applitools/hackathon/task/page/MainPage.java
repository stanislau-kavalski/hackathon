package com.applitools.hackathon.task.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/12/2019
 *
 * @author Stanislau Kavalski
 */
public class MainPage extends BasePage {
    private static final By LOGO = By.className("logo-label");

    public WebElement getLogo() {
        return findElement(LOGO);
    }

    public List<Map<String, String>> parseTransactionTableTable() {
        return parseTable(By.id("transactionsTable"));
    }

    public WebElement getTransactionTable() {
        return findElement(By.id("transactionsTable"));
    }

    public void sortByAmount() {
        List<Map<String, String>> initialValue = parseTransactionTableTable();
        findElement(By.id("amount")).click();
    }

    public WebElement getBanner(String id) {
        return findElement(By.id(id));
    }

    public ExpensesPage openExpensesPage() {
        findElement(By.id("showExpensesChart")).click();
        return new ExpensesPage();
    }
}
