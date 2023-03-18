package com.promineotech.jeep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.service.JeepSalesService;

import lombok.extern.slf4j.Slf4j;

//import com.promineotech.entity.Jeep;

@RestController
@Slf4j
public class BasicJeepSalesController implements JeepSalesController {
	
	@Autowired //tells spring that you want an object to be injected here
	private JeepSalesService jeepSalesService;
	
	@Override
	public List<Jeep> fetchJeeps(JeepModel model, String trim) {
		//curly braces means a replaceable parameter
		log.info("model={}, trim={}", model, trim);
		return jeepSalesService.fetchJeeps(model, trim);
	}

}

/*
 * log.info is a level as well as log.debug
 * log.debug will not show logger on the consol unless you create a yaml file in the resources 
 * folder to change which level the logger will show up
 * logger info will also not show up if you're running a unit test; you need to add the yaml file
 * from the main resources section, place it into the test resources file and rename it; right
 * click and then refactor
 * 
 */
