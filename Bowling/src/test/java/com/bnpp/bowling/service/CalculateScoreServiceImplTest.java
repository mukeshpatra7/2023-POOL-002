package com.bnpp.bowling.service;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalculateScoreServiceImplTest {

	private CalculateScoreServiceImpl calculateScoreServiceImpl;

	@Mock
	private BowlingRuleServiceImpl bowlingRuleServiceImpl;

	@BeforeEach
	void setup() {
		calculateScoreServiceImpl = new CalculateScoreServiceImpl(bowlingRuleServiceImpl);
	}

	@DisplayName("Normal Scenario")
	@Test
	void testcalculateScoreWithZero() {
		int[] roll = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 6, 3, 1, 3, 2, 3, 3, 6, 4, 5 };
		assertEquals(64, calculateScoreServiceImpl.calculateScore(roll).getScore());
	}

	@DisplayName("When Bowling rolls has a miss scenario")
	@Test
	void testcalculateScoreWithAMissScenario() {
		int[] roll = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 6, 3, 1, 3, 2, 3, 3, 6, 0, 0 };
		assertEquals(55, calculateScoreServiceImpl.calculateScore(roll).getScore());
	}

	@DisplayName("When Bowling frames has a miss scenario")
	@Test
	void testCalculateScoreForFrameMissScenario() {
		int[] roll = new int[] { 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0 };
		assertEquals(90, calculateScoreServiceImpl.calculateScore(roll).getScore());
	}

	@DisplayName("When Bowling has spare scenario")
	@Test
	void testCalculateScoreForSpare() {
		lenient().when(bowlingRuleServiceImpl.isSpare(5, 5)).thenReturn(true);
		int[] roll = new int[] { 0, 0, 5, 5, 1, 0, 1, 1, 1, 2, 3, 1, 2, 2, 4, 4, 1, 1, 1, 2 };
		assertEquals(38, calculateScoreServiceImpl.calculateScore(roll).getScore());
	}

	@DisplayName("When Bowling rolls has all spare scenario")
	@Test
	void testCalculateScoreForALLSpare() {
		when(bowlingRuleServiceImpl.isSpare(anyInt(), anyInt())).thenReturn(true);
		int[] roll = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
		assertEquals(150, calculateScoreServiceImpl.calculateScore(roll).getScore());
	}

	@DisplayName("When Bowling has Strike scenario")
	@Test
	void testCalculateScoreForStrike() {
		lenient().when(bowlingRuleServiceImpl.isStrike(10)).thenReturn(true);
		int[] roll = new int[] { 10, 0, 0, 0, 1, 1, 1, 2, 3, 1, 2, 2, 4, 4, 1, 1, 1, 2, 1 };
		assertEquals(37, calculateScoreServiceImpl.calculateScore(roll).getScore());
	}

}
