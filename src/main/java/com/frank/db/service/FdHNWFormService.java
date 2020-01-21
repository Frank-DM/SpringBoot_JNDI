package com.frank.db.service;


import com.frank.db.domain.FdHNWForm;

import java.util.List;

public interface FdHNWFormService {
	
	List<FdHNWForm> selectByPrimaryKey(Long rowID);

	
}
