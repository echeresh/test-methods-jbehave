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
import ru.nsu.fit.tests.shared.AllureUtils;

/**
 * @author Timur Zolotuhin (e-mail: tzolotuhin@parallels.com)
 */
public class MainSteps extends Steps {
    private ValidationChecker validationChecker;
    private StoryContext storyContext;

    private double stringToDouble(String s) {
    	double d;
		switch (s) {
    		case "NaN":
    			d = Double.NaN;
    			break;
    		case "-Infinity":
    			d = Double.NEGATIVE_INFINITY;
    			break;
    		case "+Infinity":
    		case "Infinity":
    			d = Double.POSITIVE_INFINITY;
    			break;
    		default:
    			d = Double.parseDouble(s);
    	}
    	return d;
    }

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
    @Features({"Keyboard feature", "Subtraction", "Addition", "Multiplication", "Division"})
    public void userTypesExpressionUsingKeyboard(String expr) {
        expr = storyContext.replaceVars(expr);
        Calculator calculator = storyContext.getCalculator();
        calculator.typeKeyboard(expr);
    }

    @Then("Approximate result is $resultString")
    @Severity(SeverityLevel.BLOCKER)
    @Features("UI feature")
    public void checkResultApproximately(String resultString) {
    	double result = stringToDouble(resultString);
        Calculator calculator = storyContext.getCalculator();
    	AllureUtils.saveTextLog(String.format("Result is %s", resultString));
    	AllureUtils.saveImageAttach("Result screen", calculator.makeScreenshot());
        validationChecker.assertDoubleEqualsApproximately(Double.parseDouble(calculator.getInput()), result);
    }

    @Then("Result is $resultString")
    @Severity(SeverityLevel.BLOCKER)
    @Features("UI feature")
    public void checkResult(String resultString) {
    	double result = stringToDouble(resultString);
        Calculator calculator = storyContext.getCalculator();
    	AllureUtils.saveTextLog(String.format("Result is %s", resultString));
    	AllureUtils.saveImageAttach("Result screen", calculator.makeScreenshot());
        validationChecker.assertDoubleEquals(Double.parseDouble(calculator.getInput()), result);
    }

    @BeforeScenario
    public void beforeScenario() {
        Calculator calculator = CalculatorService.newCalculator();
        storyContext.setCalculator(calculator);
        validationChecker = new ValidationChecker();
    }

    @AfterScenario
    public void afterScenario() {
        Calculator calculator = storyContext.getCalculator();
        calculator.close();
    }
}
