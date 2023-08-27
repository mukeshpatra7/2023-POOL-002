package com.bnpp.bowling.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bnpp.bowling.model.BowlingInput;

@ExtendWith(MockitoExtension.class)
class GameServiceImplTest {

	private GameServiceImpl bowlingGameServiceImpl;

	@Mock
	private CalculateScoreService calculateScoreService;

	@Captor
	ArgumentCaptor<int[]> captor;

	@BeforeEach
	void setup() {
		bowlingGameServiceImpl = new GameServiceImpl(calculateScoreService);
	}

	@DisplayName("Normal Scenario")
	@Test
	void testcalculateScore() {
		String input = "11 22 33 44 44 63 13 23 36 45";
		int[] roll = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 6, 3, 1, 3, 2, 3, 3, 6, 4, 5 };
		bowlingGameServiceImpl.play(new BowlingInput(input));
		verify(calculateScoreService, times(1)).calculateScore(captor.capture());
		assertArrayEquals(roll, captor.getValue());
	}

	@DisplayName("When Bowling rolls has a miss scenario")
	@Test
	void testcalculateScoreWithAMissScenario() {
		String input = "11 22 33 44 44 63 13 23 36 --";
		int[] roll = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 6, 3, 1, 3, 2, 3, 3, 6, 0, 0 };
		bowlingGameServiceImpl.play(new BowlingInput(input));
		verify(calculateScoreService, times(1)).calculateScore(captor.capture());
		assertArrayEquals(roll, captor.getValue());
	}

}
