package com.cognizant.estockmarketquery.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.estockmarketquery.model.Company;
import com.cognizant.estockmarketquery.service.CompanyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/query/market/company")
@Api(value = "company", description = "Operations fetch the company details")
public class CompanyController {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CompanyService companyService;

	@GetMapping(value = "/getall")
	@ApiOperation(value = "Fetch companies", notes="Header is not required", response = List.class)
public ResponseEntity<List<Company>> getCompany() {
		LOGGER.info("Getting details of all the companies ");
		return new ResponseEntity<List<Company>>(companyService.getCompany(), HttpStatus.OK);
	}

	@GetMapping(value = "/info/{code}")
	@ApiOperation(value = "Fetch company through code", notes="Header is not required", response = Company.class)
	public ResponseEntity<Company> getCompanyId(@PathVariable String code) {
		LOGGER.info("Fetching company detail based on its code {}", code);
		return new ResponseEntity<Company>(companyService.getCompanyById(code), HttpStatus.OK);
	}
}
