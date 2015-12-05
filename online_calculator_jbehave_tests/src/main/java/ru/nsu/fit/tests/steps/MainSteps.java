package ru.nsu.fit.tests.steps;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.testng.Assert;
import ru.nsu.fit.tests.services.browser.Browser;
import ru.nsu.fit.tests.services.browser.BrowserService;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.model.SeverityLevel;

/**
 * @author Timur Zolotuhin (e-mail: tzolotuhin@parallels.com)
 */
public class MainSteps extends Steps {
    // Constants
    private static final By inputElement = By.xpath("//input[@type='text' and @name='Input']");
    private static final By equalElement = By.xpath("//input[@type='button' and @name='DoIt']");
    private static final By plusElement = By.xpath("//input[@type='button' and @name='plus']");
    private static final By mulElement = By.xpath("//input[@type='button' and @name='times']");
    private static final By oneElement = By.xpath("//input[@type='button' and @name='one']");
    private static final By twoElement = By.xpath("//input[@type='button' and @name='two']");
    private static final By threeElement = By.xpath("//input[@type='button' and @name='three']");

    // Main data
    private Browser browser;

    @Given("Start page of Online Calculator in browser")
    @Severity(SeverityLevel.BLOCKER)
    @Features("UI feature")
    public void openCalculator() {
        browser.openPage("http://testmethods.tmweb.ru/");
    }

    @When("User types expression $expr using user interface")
    @Severity(SeverityLevel.BLOCKER)
    @Features({"UI feature", "Subtraction", "Addition", "Multiplication", "Division"})
    public void userTypesExpressionUsingUI(String expr) {
        for (int i = 0; i < expr.length(); i++) {
            byte symbol = expr.getBytes()[i];
            switch (symbol) {
                case '1':
                    browser.click(oneElement);
                    break;
                case '2':
                    browser.click(twoElement);
                    break;
                case '3':
                    browser.click(threeElement);
                    break;
                case '+':
                    browser.click(plusElement);
                    break;
                case '*':
                    browser.click(mulElement);
                    break;
                case '=':
                    browser.click(equalElement);
                    break;
                default: throw new IllegalArgumentException("Could not find ui element for following symbol: " + symbol);
            }
        }
    }

    @When("User types expression $expr using keyboard")
    @Severity(SeverityLevel.BLOCKER)
    @Features({"UI feature", "Subtraction", "Addition", "Multiplication", "Division"})
    public void userTypesExpressionUsingKeyboard(String expr) {
        browser.typeText(inputElement, expr);
    }

    @Then("Result is $result")
    @Severity(SeverityLevel.BLOCKER)
    @Features("UI feature")
    public void checkResult(int result) {
        Assert.assertEquals(Integer.parseInt(browser.getValue(inputElement)), result);
    }

    @BeforeScenario
    public void beforeScenario() {
        browser = BrowserService.openNewBrowser();
    }

    @AfterScenario
    public void afterScenario() {
        browser.close();
    }
}
