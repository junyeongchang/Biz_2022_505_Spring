package com.callor.score.service;

import org.apache.ibatis.annotations.Param;

import com.callor.score.persistance.ScoreDao;

public interface ScoreService extends ScoreDao{
	
	public int updateScore(String st_num, String[] sb_code, String[] sc_score);
	public int updateScore(@Param("st_num") String st_num, 
							@Param("sb_code") String sb_code, 
							@Param("sc_score") String sc_score);
}
