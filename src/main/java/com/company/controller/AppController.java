package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.service.AppService;

@RestController
@RequestMapping(value = "/wish")
public class AppController {

	@Autowired
	AppService appService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "App working properly!";
	}

	@RequestMapping(method = { RequestMethod.PUT })
	public String save(@RequestParam String description) {
		appService.save(description);
		return "Saved Properly!";
	}

//	@RequestMapping(method = { RequestMethod.PUT })
//	public List<AppVo> listAll() {
//		return appService.listAll();
//	}
}