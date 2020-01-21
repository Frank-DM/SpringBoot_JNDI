package com.frank.db.dao;

import com.frank.db.domain.FdHNWForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FdHNWFormMapper {

	//@Select("select * from FD_HNW_FORM")
	List<FdHNWForm> selectByPrimaryKey(Long rowID);
}