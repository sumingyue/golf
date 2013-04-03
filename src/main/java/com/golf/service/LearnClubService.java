package com.golf.service;

import java.util.List;

import com.golf.entity.LearnClub;

public interface LearnClubService {

	public int deleteLearnClub(int learnClubId);

	public LearnClub findLearnClub(int learnClubId);

	public int insertLearnClub(LearnClub learnClub);

	public List<LearnClub> queryAllLearnClubs();

	public int updateLearnClub(LearnClub learnClub);

}
