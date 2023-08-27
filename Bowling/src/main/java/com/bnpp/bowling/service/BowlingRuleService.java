package com.bnpp.bowling.service;

public interface BowlingRuleService {
	boolean isSpare(int prevRoll, int nextRoll);

	boolean isStrike(int roll);
}
