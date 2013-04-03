package com.golf.service;

import java.util.List;

import com.golf.entity.DrivingRange;

public interface DrivingRangeService {

	public int deleteDrivingRange(int drivingRangeId);

	public DrivingRange findDrivingRange(int drivingRangeId);

	public int insertDrivingRange(DrivingRange drivingRange);

	public List<DrivingRange> queryAllDrivingRanges();

	public int updateDrivingRange(DrivingRange drivingRange);

}
