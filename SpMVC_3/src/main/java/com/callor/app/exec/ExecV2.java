package com.callor.app.exec;

import java.util.ArrayList;
import java.util.List;

public class ExecV2 {

	public static void main(String[] args) {

		int[] intKor = new int[5];
		int[] intEng = new int[5];
		int[] intMath = new int[5];
		int[] intSum = new int[5];
		List<ScoreVO> scList = new ArrayList<>();
		for (int i = 0; i < intKor.length; i++) {
			int iKor = (int) (Math.random() * 100) + 1;
			int iEng = (int) (Math.random() * 100) + 1;
			int iMath = (int) (Math.random() * 100) + 1;
			int iSum = iKor + iEng + iMath;
			ScoreVO scVO = ScoreVO.builder().intKor(iKor).intEng(iEng).intMath(iMath).intSum(iSum).build();
			scList.add(scVO);
		}
		printScore(scList);
		System.out.println();
		scList = _t(scList);
		printScore(scList);
	}

	private static List<ScoreVO> _t(List<ScoreVO> _tscList) {
		List<ScoreVO> scList = _tscList;
		int size = scList.size();
		// 정렬하기
		for (int i = 0; i < size; i++) {
			for (int j = i+1; j < size; j++) {
				if(scList.get(i).getIntSum()> scList.get(j).getIntSum()) {
					
				}
			}
		}
		return scList;
	}

	private static void printScore(List<ScoreVO> scList) {
		int size = scList.size();
		for (int i = 0; i < size; i++) {
			System.out.printf("국어 : %d\t 영어 : %d\t 수학%d\t 총점 : %d\n", scList.get(i).getIntKor(),
					scList.get(i).getIntEng(), scList.get(i).getIntMath(), scList.get(i).getIntSum());
		}
	}

}
