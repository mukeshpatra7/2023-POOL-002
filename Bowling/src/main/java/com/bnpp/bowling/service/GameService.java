package com.bnpp.bowling.service;

import com.bnpp.bowling.model.BowlingInput;
import com.bnpp.bowling.model.BowlingResponse;

public interface GameService {

	public BowlingResponse play(BowlingInput input);

}
