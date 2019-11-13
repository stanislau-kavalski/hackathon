package com.applitools.hackathon.task.page;

import com.applitools.hackathon.task.driver.DriverProvider;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Base page.
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/12/2019
 *
 * @author Stanislau Kavalski
 */
public class BasePage {
    protected WebElement findElement(By locator) {
        return DriverProvider.getDriver().findElement(locator);
    }

    protected List<Map<String, String>> parseTable(By by) {
        WebElement table = findElement(by);
        List<WebElement> headerLine = table.findElements(By.tagName("th"));
        List<String> headers = headerLine.stream().map(header -> header.getText().toUpperCase())
            .collect(Collectors.toList());
        List<WebElement> tbody = table.findElements(By.tagName("tbody"));
        Assertions.assertThat(tbody)
            .isNotEmpty()
            .hasSize(1);
        List<WebElement> rows = tbody.get(0).findElements(By.tagName("tr"));
        List<Map<String, String>> headerToValueMapList = new ArrayList<>(rows.size());
        int headersSize = headers.size();
        rows.forEach(row -> {
            Map<String, String> rowHeaderToValueMap = new HashMap<>(headersSize);
            IntStream.range(0, headersSize).forEach(columnIndex -> {
                List<WebElement> columns = row.findElements(By.tagName("td"));
                Assertions.assertThat(columns.size()).isEqualTo(headersSize);
                rowHeaderToValueMap.put(headers.get(columnIndex), columns.get(columnIndex).getText());
            });
            headerToValueMapList.add(rowHeaderToValueMap);
        });
        return headerToValueMapList;
    }

    protected void open(String uri) {
        DriverProvider.getDriver().get(uri);
    }
}
