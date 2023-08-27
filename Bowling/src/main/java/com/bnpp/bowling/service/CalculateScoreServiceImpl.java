package com.bnpp.bowling.service;

import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.bnpp.bowling.constant.Constant;
import com.bnpp.bowling.model.BowlingResponse;

@Service
public class CalculateScoreServiceImpl implements CalculateScoreService {
	private int cursor = Constant.ZERO;
	private int gameScore = Constant.ZERO;

	@Override
	public BowlingResponse calculateScore(int[] roll) {
		cursor = Constant.ZERO;
		IntStream.iterate(Constant.ZERO, frame -> frame + Constant.ONE).limit(Constant.TEN).forEach(frame -> {
			Integer frameScore = Constant.ZERO;

			frameScore = Integer.sum(frameScore, Integer.sum(roll[cursor], roll[cursor + Constant.ONE]));
			cursor += Constant.TWO;
			gameScore = Integer.sum(frameScore, gameScore);
		});
		return new BowlingResponse(gameScore);
	}

}
