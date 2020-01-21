package com.frank.db.service.impl;


import com.frank.db.dao.FdHNWFormMapper;
import com.frank.db.domain.FdHNWForm;
import com.frank.db.service.FdHNWFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class FdHNWFormServiceImpl implements FdHNWFormService {
	
	
	@Autowired
	FdHNWFormMapper fdHNWFormMapper;

	@Override
	public List<FdHNWForm> selectByPrimaryKey(Long rowID) {
		return fdHNWFormMapper.selectByPrimaryKey(rowID);
	}
}
