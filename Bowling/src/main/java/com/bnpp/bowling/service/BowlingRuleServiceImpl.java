package com.bnpp.bowling.service;

import org.springframework.stereotype.Service;

import com.bnpp.bowling.constant.Constant;

@Service
public class BowlingRuleServiceImpl implements BowlingRuleService {

	@Override
	public boolean isSpare(int prevRoll, int nextRoll) {
		return prevRoll + nextRoll == Constant.TEN;
	}

}