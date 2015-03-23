package com.lm.dao;

import java.util.List;

import com.lm.entity.UserEntity;

public interface IUserDao {
	
	UserEntity getUserEntityById(String userId);
	
	List<UserEntity> getUserEntities();
	
	int insertUser(UserEntity userEntity);
}
