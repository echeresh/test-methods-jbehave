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


public class LoopSteps extends Steps {
	private StoryContext storyContext;

    public LoopSteps(StoryContext storyContext) {
        this.storyContext = storyContext;
    }


    @When("User computes series $var equals $expr with $niter iterations")
    @Severity(SeverityLevel.BLOCKER)
    //@Features({"UI feature"})
    public void storeInVar(String var, String expr, int niter) {
        Calculator calculator = storyContext.getCalculator();
        for (int i = 0; i < niter; i++) {
        	String tExpr = storyContext.replaceVars(expr);
        	calculator.typeKeyboard(tExpr);
        	calculator.typeUI("=");
        	String result = calculator.getInput();
        	calculator.clearInput();
        	storyContext.saveVar(var, result);
        }
    }
}