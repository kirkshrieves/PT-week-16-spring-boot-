package com.promineotech.jeep.controller;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.jeep.Constants;
import com.promineotech.jeep.entity.JeepModel;

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
@RequestMapping("/jeeps")
@OpenAPIDefinition(info = @Info(title = "Jeep Sales Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})

public interface JeepSalesController { 
	//deleted here to put into it's own class: public static final int TRIM_MAX_LENGTH = 30;
	//com.promineotech.jeep - new class: Constants. 
	//^^^^you can use this in the test controller as well as the class

	// @formatter:off
	@Operation(
			summary = "Returns a list of Jeeps",
			description = "Returns a list of Jeeps given an optional model and/or trim",
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
							responseCode = "200",
							description = "A list of Jeeps is returned",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Jeep.class))),
					@ApiResponse(
							responseCode = "400",
							description = "The request parameters are invalid",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404",
							description = "No Jeeps were found with the input criteria",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500",
							description = "An unplanned error occurred.",
							content = @Content(mediaType = "application/json"))
			},
			parameters = {
					@Parameter(
							name = "model",
							allowEmptyValue = false,
							required = false,
							description = "The model name (i.e., 'WRANGLER')"),
					@Parameter(
							name = "trim",
							allowEmptyValue = false,
							required = false,
							description = "The trim level (i.e., 'Sport'")
			}
		)
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Jeep> fetchJeeps(
			@RequestParam(required = false) 
				JeepModel model,   //an enum object is a safer way to write this than with a String
			@Length(max = Constants.TRIM_MAX_LENGTH)//do length validation first when utilizing regular expressions (regexp)
			//^^^^^max did equal 30; highlighted, selected refactor then extract constant to change it
			//to TRIM_MAX_LENGTH to put into a constance class
			@Pattern(regexp = "[\\w\\s]*")//this prevents unnecessary characters being passed in as
			//parameters. w = word, s = space, * = 0 or more
			//regexp is extremely innefficient with long strings
			@RequestParam(required = false) 
				String trim);
	// @formatter:on
}
