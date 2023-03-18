package com.promineotech.jeep.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;

//import com.promineotech.entity.Jeep;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

/*
 * CNTL + SHIFT + O to organize and import OpenAPIDefinition after dependency update
 * in the pom.xml file
 */
@Validated
@RequestMapping("/orders")
@OpenAPIDefinition(info = @Info(title = "Jeep Order Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})

public interface JeepOrderController { 
	//deleted here to put into it's own class: public static final int TRIM_MAX_LENGTH = 30;
	//com.promineotech.jeep - new class: Constants. 
	//^^^^you can use this in the test controller as well as the class

	// @formatter:off
	@Operation(
			summary = "Create an order for a Jeep",
			description = "Returns the created Jeep",
			responses = {
					/*
					 * *********************************************************
					 * MAKE SURE YOU IMPORT ANNOTATIONS INSTEAD OF TYPE THEM OUT
					 * *******************************************************
					 * CNTL + SPACE OR RIGHT CLICK AFTER TYPING ANNOTATION
					 * *****************************************************
					 * DO NOT TYPE PARENTHESIS OR PARAMETERS BEFORE TRYING TO SELECT
					 * *********************************************************
					 * MAKE SUR EYOU IMPORT ANNOTATIONS INSTEAD OF TYPE THEM OUT
					 * **********************************************************
					 */
					
					//these ApiResponses were tested in the FetchJeepTest.java class
					@ApiResponse(
							responseCode = "201",
							description = "A created Jeep is returned",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Order.class))),
					@ApiResponse(
							responseCode = "400",
							description = "The request parameters are invalid",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404",
							description = "A Jeep component was not found with the input criteria",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500",
							description = "An unplanned error occurred.",
							content = @Content(mediaType = "application/json"))
			},
			parameters = {
					@Parameter(
							name = "OrderRequest",
							required = true,
							description = "The order as JSON"),
			}
		)
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Order createOrder(@Valid @RequestBody OrderRequest orderRequest);
}
