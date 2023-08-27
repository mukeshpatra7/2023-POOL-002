package com.bnpp.bowling.service;

import java.util.Arrays;

import com.bnpp.bowling.constant.Constant;
import com.bnpp.bowling.model.BowlingInput;
import com.bnpp.bowling.model.BowlingResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
	private final CalculateScoreService calculateScoreService;

	@Override
	public BowlingResponse play(BowlingInput input) {
		String[] rolls = input.getBowlingRoll().replace(Constant.FRAME_SEPEARATOR, Constant.ROLLS_SEPERATOR)
				.split(Constant.ROLLS_SEPERATOR);
		return calculateScoreService.calculateScore(Arrays.stream(rolls).mapToInt(Integer::parseInt).toArray());
	}

}
