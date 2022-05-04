package com.callor.app.exec;

import com.callor.app.domain.StudentVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ScoreVO {
	private int intKor;
	private int intEng;
	private int intMath;
	
	private int intSum;
}
