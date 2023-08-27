package com.bnpp.bowling.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.bowling.model.BowlingInput;
import com.bnpp.bowling.model.BowlingResponse;
import com.bnpp.bowling.service.GameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BowlingController {
	private final GameService gameService;

	@PostMapping(value = "/bowling/roll")
	ResponseEntity<BowlingResponse> calculateBowlingScore(@RequestBody BowlingInput input) {
		return new ResponseEntity<>(gameService.play(input), HttpStatus.OK);
	}
}