package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.dao.AppDao;
import com.company.vo.AppVo;

@Component
public class AppService {

	@Autowired
	AppDao appDao;

	public List<AppVo> listAll() {
		return appDao.listAll();
	}
	
	public boolean save(String wish) {
		return appDao.save(wish);
	}
}