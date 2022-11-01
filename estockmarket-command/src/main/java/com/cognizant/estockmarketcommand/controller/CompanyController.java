package com.cognizant.estockmarketcommand.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.estockmarketcommand.model.Company;
import com.cognizant.estockmarketcommand.service.CompanyService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/command/market/company")
@Api(value = "company", description = "Operations pertaining to register and remove the company")
public class CompanyController {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CompanyService companyService;

	@PostMapping(value = "/register")
	@ApiOperation(value = "Register company", notes="Header is not required", response = Company.class)
	public ResponseEntity<Company> createCompany(@RequestBody Company company) throws JsonProcessingException {
		LOGGER.info("Registering new company === {}", company);
		return companyService.createCompany(company);
	}

	@DeleteMapping(value = "/delete/{code}")
	@ApiOperation(value = "Delete company by code", notes="Header is not required", response = Boolean.class)
	public ResponseEntity<Boolean> removeCompany(@PathVariable String code)
			throws JsonProcessingException, NumberFormatException {
		LOGGER.info("Removing company details === {}", code);
		return companyService.removeCompany(code);
	}
}
