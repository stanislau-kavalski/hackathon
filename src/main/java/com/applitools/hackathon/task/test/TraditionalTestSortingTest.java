package com.applitools.hackathon.task.test;

import com.applitools.hackathon.task.driver.DriverProvider;
import com.applitools.hackathon.task.page.MainPage;
import com.applitools.hackathon.task.utils.PropertiesProvider;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Task 3.
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/12/2019
 *
 * @author Stanislau Kavalski
 */
public class TraditionalTestSortingTest extends TraditionalBaseTest {
    private static final String REMOVE_NON_DIGITS_REGEX = "[^0-9\\.\\-\\\\s]";
    private MainPage mainPage = new MainPage();

    @Test
    public void sorting() {
        DriverProvider.getDriver().get(PropertiesProvider.getAppUrl());
        tryLogin("login", "password");
        Map<String, Map<String, String>> initialTableSorted = sortTable(convert(mainPage.parseTransactionTableTable(), "AMOUNT"));
        mainPage.sortByAmount();
        Map<String, Map<String, String>> tableAfterSorting = convert(mainPage.parseTransactionTableTable(), "AMOUNT");
        Assertions.assertThat(initialTableSorted).containsExactlyEntriesOf(tableAfterSorting);
    }

    private Map<String, Map<String, String>> sortTable(Map<String, Map<String, String>> table) {
        return table.entrySet().stream()
            .sorted(Map.Entry.comparingByKey((a, b) ->
                Double.valueOf(a) == Double.valueOf(b) ? 0 :
                    Double.valueOf(a) < Double.valueOf(b) ? -1 : 1))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> x, LinkedHashMap::new));
    }

    private Map<String, Map<String, String>> convert(List<Map<String, String>> table, String column) {
        return table.stream()
            .collect(Collectors.toMap(z -> z.remove(column).replaceAll(REMOVE_NON_DIGITS_REGEX, StringUtils.EMPTY),
                y -> y,
                (a, b) -> b,
                LinkedHashMap::new));
    }
}
