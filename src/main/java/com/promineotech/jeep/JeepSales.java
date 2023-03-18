package com.promineotech.jeep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.promineotech.ComponentsScanMarker;

//@SpringBootApplication(scanBasePackages = "com.promineotech") -- typing mistakes can be made here
@SpringBootApplication(scanBasePackageClasses = {ComponentsScanMarker.class})//ensures no scan errors
//if package scans aren't being found, check here ^^^^
public class JeepSales {

	public static void main(String[] args) {
		SpringApplication.run(JeepSales.class, args);

	}

}

/*
* right click
* run as spring boot
* if successful, open web browser
* input 'http://localhost:8080/swagger-ui.html' ---- reference 'Tomcat started' line for port
* 
* http://localhost:8080/jeeps?model=WRANGLER&trim=Sport also show up on the logger
* 
* if spring doesn't know about your classes, make sure component scan is done correctly
*/