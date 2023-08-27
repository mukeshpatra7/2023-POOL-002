package com.bnpp.bowling.model;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BowlingInput {
	@NotBlank
	@Schema(name = "Bowling Roll", example = "X -- -1 11 23 12 24 41 11 21", required = true)
	String bowlingRoll;
}