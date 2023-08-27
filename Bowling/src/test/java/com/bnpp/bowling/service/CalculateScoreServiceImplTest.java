package com.bnpp.bowling.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculateScoreServiceImplTest {

	private CalculateScoreServiceImpl calculateScoreServiceImpl;

	@BeforeEach
	void setup() {
		calculateScoreServiceImpl = new CalculateScoreServiceImpl();
	}

	@DisplayName("Normal Scenario")
	@Test
	void testcalculateScoreWithZero() {
		int[] roll = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 6, 3, 1, 3, 2, 3, 3, 6, 4, 5 };
		assertEquals(64, calculateScoreServiceImpl.calculateScore(roll).getScore());
	}

}
