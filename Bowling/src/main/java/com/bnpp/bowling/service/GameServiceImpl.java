package com.bnpp.bowling.service;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.bnpp.bowling.constant.Constant;
import com.bnpp.bowling.model.BowlingInput;
import com.bnpp.bowling.model.BowlingResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
	private final CalculateScoreService calculateScoreService;

	@Override
	public BowlingResponse play(BowlingInput input) {
		String[] rolls = input.getBowlingRoll().replace(Constant.FRAME_SEPEARATOR, Constant.ROLLS_SEPERATOR)
				.split(Constant.ROLLS_SEPERATOR);
		updateCharacterWithValue(rolls);
		return calculateScoreService.calculateScore(Arrays.stream(rolls).mapToInt(Integer::parseInt).toArray());
	}

	private void updateCharacterWithValue(String[] rolls) {
		IntStream.iterate(Constant.ZERO, roll -> roll + Constant.ONE).limit(rolls.length).forEach(i -> {
			if (rolls[i].equals(Constant.MISS)) {
				rolls[i] = String.valueOf(Constant.ZERO);
			} else if (rolls[i].equals(Constant.SPARE)) {
				rolls[i] = String.valueOf(Constant.TEN - Integer.parseInt(rolls[i - 1]));
			} else if (rolls[i].equals(Constant.STRIKE)) {
				rolls[i] = String.valueOf(Constant.TEN);
			}
		});
	}

}
