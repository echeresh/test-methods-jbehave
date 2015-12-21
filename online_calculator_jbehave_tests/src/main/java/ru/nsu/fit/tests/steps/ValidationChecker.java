package ru.nsu.fit.tests.steps;

import org.testng.Assert;

public class ValidationChecker {
	private double epsilon = 1e-5;

	public void assertDoubleEquals(double v0, double v1) {
		Assert.assertEquals(v0, v1);
	}

	public void assertDoubleEqualsApproximately(double v0, double v1) {
		Assert.assertTrue(Math.abs(v0 - v1) < epsilon);
	}
}