package com.bnpp.bowling.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bnpp.bowling.model.BowlingInput;
import com.bnpp.bowling.model.BowlingResponse;
import com.bnpp.bowling.service.GameServiceImpl;

@ExtendWith(MockitoExtension.class)
class BowlingControllerTest {

	private BowlingController controller;
	@Mock
	private GameServiceImpl gameServiceImpl;

	@BeforeEach
	void setup() {
		controller = new BowlingController(gameServiceImpl);
	}

	@Test
	void testcalculateBowlingScoreForSuccess() {
		when(gameServiceImpl.play(Mockito.any())).thenReturn(new BowlingResponse(List.of(10, 15, 11, 0)));
		ResponseEntity<BowlingResponse> res = controller.calculateBowlingScore(new BowlingInput(Mockito.anyString()));
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(36, res.getBody().getScore());
	}

}
