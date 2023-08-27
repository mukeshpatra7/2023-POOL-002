package com.bnpp.bowling.model;

import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BowlingResponse {

	@NonNull
	List<Integer> frames;
	long score;

	public long getScore() {
		return frames.stream().mapToLong(Long::valueOf).sum();
	}
}