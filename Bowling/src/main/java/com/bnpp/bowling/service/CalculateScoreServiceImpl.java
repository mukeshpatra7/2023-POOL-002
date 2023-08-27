package com.bnpp.bowling.service;

import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.bnpp.bowling.constant.Constant;
import com.bnpp.bowling.model.BowlingResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalculateScoreServiceImpl implements CalculateScoreService {
	private final BowlingRuleService bowlingRuleService;
	private int cursor = Constant.ZERO;
	private int gameScore = Constant.ZERO;

	@Override
	public BowlingResponse calculateScore(int[] roll) {
		cursor = Constant.ZERO;
		IntStream.iterate(Constant.ZERO, frame -> frame + Constant.ONE).limit(Constant.TEN).forEach(frame -> {
			Integer frameScore = Constant.ZERO;

			if (bowlingRuleService.isStrike(roll[cursor])) {
				frameScore = Integer.sum(frameScore, Integer.sum(roll[cursor + Constant.ONE],
						Integer.sum(roll[cursor + Constant.TWO], Constant.TEN)));
				cursor++;
			} else if (bowlingRuleService.isSpare(roll[cursor], roll[cursor + Constant.ONE])) {
				frameScore = Integer.sum(frameScore, Integer.sum(roll[cursor + Constant.TWO], Constant.TEN));
				cursor += Constant.TWO;
			} else {
				frameScore = Integer.sum(frameScore, Integer.sum(roll[cursor], roll[cursor + Constant.ONE]));
				cursor += Constant.TWO;
			}

			gameScore = Integer.sum(frameScore, gameScore);
		});
		return new BowlingResponse(gameScore);
	}

}
