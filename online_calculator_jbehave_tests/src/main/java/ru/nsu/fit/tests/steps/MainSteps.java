package ru.nsu.fit.tests.steps;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.testng.Assert;
import ru.nsu.fit.tests.services.calculator.Calculator;
import ru.nsu.fit.tests.services.calculator.CalculatorService;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.model.SeverityLevel;

/**
 * @author Timur Zolotuhin (e-mail: tzolotuhin@parallels.com)
 */
public class MainSteps extends Steps {
    private Checker checker;
    private StoryContext storyContext;

    public MainSteps(StoryContext storyContext) {
        this.storyContext = storyContext;
    }

    @Given("Start page of Online Calculator in browser")
    @Severity(SeverityLevel.BLOCKER)
    @Features("UI feature")
    public void openCalculator() {
    }

    @When("User types expression $expr using user interface")
    @Severity(SeverityLevel.BLOCKER)
    @Features({"UI feature", "Subtraction", "Addition", "Multiplication", "Division"})
    public void userTypesExpressionUsingUI(String expr) {
        Calculator calculator = storyContext.getCalculator();
        calculator.typeUI(expr);
    }

    @When("User types expression $expr using keyboard")
    @Severity(SeverityLevel.BLOCKER)
    @Features({"UI feature", "Subtraction", "Addition", "Multiplication", "Division"})
    public void userTypesExpressionUsingKeyboard(String expr) {
        expr = storyContext.replaceVars(expr);
        Calculator calculator = storyContext.getCalculator();
        calculator.typeKeyboard(expr);
    }

    @Then("Approximate result is $result")
    @Severity(SeverityLevel.BLOCKER)
    @Features("UI feature")
    public void checkResultApproximately(double result) {
        Calculator calculator = storyContext.getCalculator();
        checker.assertDoubleEqualsApproximately(Double.parseDouble(calculator.getInput()), result);
    }

    @Then("Result is $result")
    @Severity(SeverityLevel.BLOCKER)
    @Features("UI feature")
    public void checkResult(double result) {
        Calculator calculator = storyContext.getCalculator();
         checker.assertDoubleEquals(Double.parseDouble(calculator.getInput()), result);
    }

    @BeforeScenario
    public void beforeScenario() {
        Calculator calculator = CalculatorService.newCalculator();
        storyContext.setCalculator(calculator);
        checker = new Checker();
    }

    @AfterScenario
    public void afterScenario() {
        Calculator calculator = storyContext.getCalculator();
        calculator.close();
    }
}
