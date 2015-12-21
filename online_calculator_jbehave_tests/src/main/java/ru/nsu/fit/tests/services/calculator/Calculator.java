package ru.nsu.fit.tests.services.calculator;

import ru.nsu.fit.tests.services.browser.*;
import org.openqa.selenium.By;
import ru.nsu.fit.tests.shared.AllureUtils;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Calculator implements Closeable {
    public enum ElementType
    {
        Input,
        Equal,
        Clear,
        Plus,
        Minus,
        Mul,
        Div,
        Zero,
        One,
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine
    }

    private static final String PAGE_URL = "http://testmethods.tmweb.ru/";

    private static final By inputElement = By.xpath("//input[@type='text' and @name='Input']");
    private static final By equalElement = By.xpath("//input[@type='button' and @name='DoIt']");
    private static final By plusElement = By.xpath("//input[@type='button' and @name='plus']");
    private static final By minusElement = By.xpath("//input[@type='button' and @name='minus']");
    private static final By mulElement = By.xpath("//input[@type='button' and @name='times']");
    private static final By divElement = By.xpath("//input[@type='button' and @name='div']");
    private static final By clearElement = By.xpath("//input[@type='button' and @name='clear']");

    protected Browser browser;

    private By getDigitElement(int digit) {
        String[] digitNames =
        {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
        };
        return By.xpath("//input[@type='button' and @name='" + digitNames[digit] + "']");
    }

    
    private void setInput(String expression) {
        browser.typeText(getElement(Calculator.ElementType.Input), expression);
    }

    public Calculator() {
        browser = BrowserService.openNewBrowser();
        AllureUtils.saveTextLog("Open page");
        browser.openPage(PAGE_URL);
        AllureUtils.saveTextLog("The page was opened successfully");
        AllureUtils.saveImageAttach("Main screen", browser.makeScreenshot());
    }

    public void typeUI(String expr) {
    	AllureUtils.saveTextLog(String.format("Typing expression %s using UI", expr));
        for (int i = 0; i < expr.length(); i++) {
            byte symbol = expr.getBytes()[i];
            switch (symbol) {
                case 'c':
                case 'C':
                    browser.click(getElement(ElementType.Clear));
                    break;
                case '+':
                    browser.click(getElement(ElementType.Plus));
                    break;
                case '-':
                    browser.click(getElement(ElementType.Minus));
                    break;
                case '*':
                    browser.click(getElement(ElementType.Mul));
                    break;
                case '/':
                    browser.click(getElement(ElementType.Div));
                    break;
                case '=':
                    browser.click(getElement(ElementType.Equal));
                    break;
                case ' ':
                    break;
                default:
                    if (symbol >= '0' && symbol <= '9') {
                        int digit = symbol - '0';
                        browser.click(getElement(digit));
                        break;
                    }
                    throw new IllegalArgumentException("Could not find ui element for following symbol: " + symbol);
            }
        }
        AllureUtils.saveImageAttach("The expression is typed using UI", makeScreenshot());
    }

    public void typeKeyboard(String expr) {
    	AllureUtils.saveTextLog(String.format("Typing expression %s using keyboard", expr));
        setInput(expr);
        AllureUtils.saveImageAttach("The expression is typed using keyboard", makeScreenshot());
    }

    public String getInput() {
        return browser.getValue(inputElement);
    }

    public void calcInput() {
        browser.click(equalElement);
    }

    public void clearInput() {
        browser.click(clearElement);
    }

    @Override
    public void close() {
        browser.close();
        AllureUtils.saveTextLog("Browser was closed");
    }

    public By getElement(int digit) {
        switch (digit) {
            case 0:
                return getElement(ElementType.Zero);
            case 1:
                return getElement(ElementType.One);
            case 2:
                return getElement(ElementType.Two);
            case 3:
                return getElement(ElementType.Three);
            case 4:
                return getElement(ElementType.Four);
            case 5:
                return getElement(ElementType.Five);
            case 6:
                return getElement(ElementType.Six);
            case 7:
                return getElement(ElementType.Seven);
            case 8:
                return getElement(ElementType.Eight);
            case 9:
                return getElement(ElementType.Nine);
        }
        return null;
    }

    public By getElement(ElementType elementType) {
        switch (elementType) {
            case Equal:
                return equalElement;
            case Input:
                return inputElement;
            case Clear:
                return clearElement;
            case Plus:
                return plusElement;
            case Minus:
                return minusElement;
            case Mul:
                return mulElement;
            case Div:
                return divElement;
            case Zero:
                return getDigitElement(0);
            case One:
                return getDigitElement(1);
            case Two:
                return getDigitElement(2);
            case Three:
                return getDigitElement(3);
            case Four:
                return getDigitElement(4);
            case Five:
                return getDigitElement(5);
            case Six:
                return getDigitElement(6);
            case Seven:
                return getDigitElement(7);
            case Eight:
                return getDigitElement(8);
            case Nine:
                return getDigitElement(9);
        }
        return null;
    }

    public byte[] makeScreenshot() {
    	return browser.makeScreenshot();
    }
}
