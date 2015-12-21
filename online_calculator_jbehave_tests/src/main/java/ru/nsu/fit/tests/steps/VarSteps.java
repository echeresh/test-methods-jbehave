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

public class VarSteps extends Steps {
    private StoryContext storyContext;

    public VarSteps(StoryContext storyContext) {
        this.storyContext = storyContext;
    }

    @When("User stores expression $expr in variable $var")
    public void storeInVar(String expr, String var) {
        storyContext.saveVar(var, expr);
    }

    @When("User stores result in variable $var")
    public void storeInVar(String var) {
        Calculator calculator = storyContext.getCalculator();
        storyContext.saveVar(var, calculator.getInput());
    }

    @When("User loads from $var")
    public void loadFromVar(String var) {
        Calculator calculator = storyContext.getCalculator();
        calculator.typeKeyboard(storyContext.getVar(var));
    }

    @BeforeScenario
    public void beforeScenario() {
    }

    @AfterScenario
    public void afterScenario() {
    }
}
