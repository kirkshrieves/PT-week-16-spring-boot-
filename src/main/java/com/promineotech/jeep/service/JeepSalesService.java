package com.promineotech.jeep.service;

import java.util.List;

import com.promineotech.jeep.controller.Jeep;
import com.promineotech.jeep.entity.JeepModel;

public interface JeepSalesService {

	
	List<Jeep> fetchJeeps(JeepModel model, String trim);

}
 /*
* Remember that this project is to create a REST service that receives REST/HTTP requests
* and replies with REST/HTTP responses. The controller layer manages requests and responses.
* The service layer applies business logic. The DAO layer works directly with data sources
* (database, queue, another REST service, etc.). This REST service will read and write to a
* MySQL database. The coding is being driven with an integration test that uses the Spring
* Test Framework.
* 
* RED, GREEN, REFACTOR
* 
* a bean is a managed object to spring, not just an implementing class
*
* the interface layer helps when working on projects with teams that way one developer
* can flush out the service layer while the other developer is developing the controller layer
*/
