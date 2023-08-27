package com.bnpp.bowling.service;

import com.bnpp.bowling.model.BowlingResponse;

public interface CalculateScoreService {
	BowlingResponse calculateScore(int[] roll);
}
