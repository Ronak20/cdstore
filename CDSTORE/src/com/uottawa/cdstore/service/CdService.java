package com.uottawa.cdstore.service;

import java.util.List;

import com.uottawa.cdstore.dao.CdDriveDao;
import com.uottawa.cdstore.model.CdDrive;

public class CdService {

	private CdDriveDao cdDriveDao;

	public CdService(CdDriveDao cdDriveDao) {
		this.cdDriveDao = cdDriveDao;
	}

	public List<CdDrive> getCdDriveList() {
		return cdDriveDao.getCdDriveList();
	}

}
