package ru.nsu.fit.tests.steps;

import ru.nsu.fit.tests.services.calculator.*;
import java.util.Map;
import java.util.HashMap;

public class StoryContext {
	private Calculator calculator;
	private Map<String, String> vars;

	public StoryContext() {
		vars = new HashMap<String, String>();
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void saveVar(String varName, String value) {
		vars.put(varName, value);
	}

	public String getVar(String varName) {
		return vars.get(varName);
	}

	public String replaceVars(String expr) {
		for (String var : vars.keySet()) {
			String value = vars.get(var);
			expr = expr.replace(var, value);
		}
		return expr;
	}
}
