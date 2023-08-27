package com.bnpp.bowling.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BowlingRuleServiceImplTest {

	private BowlingRuleServiceImpl bowlingServiceimpl;

	@BeforeEach
	void setup() {
		bowlingServiceimpl = new BowlingRuleServiceImpl();
	}

	@DisplayName("Validate whether rolls is spare or not")
	@Test
	void testValidateRollIsSpare() {
		assertTrue(bowlingServiceimpl.isSpare(5, 5));
		assertTrue(bowlingServiceimpl.isSpare(9, 1));
		assertFalse(bowlingServiceimpl.isSpare(0, 4));
	}

	@DisplayName("Validate whether rolls is strike or not")
	@Test
	void testValidateRollIsStrike() {
		assertTrue(bowlingServiceimpl.isStrike(10));
		assertFalse(bowlingServiceimpl.isStrike(4));
	}
}