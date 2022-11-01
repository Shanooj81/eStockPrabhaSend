package com.cognizant.estockmarketquery.controller;

import java.text.ParseException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.estockmarketquery.model.StockAggregate;
import com.cognizant.estockmarketquery.model.StockDto;
import com.cognizant.estockmarketquery.model.Stocks;
import com.cognizant.estockmarketquery.service.StockService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/query/market/stock")
@Api(value = "stocks", description = "Operations pertaining to fetch company stock price")
public class StockController {
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StockService stockService;

	@ApiOperation(value = "Fetch company stocks based on given time frame", response = List.class)
	@GetMapping(value = "/get/{code}/{startDate}/{endDate}")
	@ResponseBody
	public ResponseEntity<List<StockDto>> getCompanyStocks(@PathVariable String code, @PathVariable String startDate, 
			@PathVariable String endDate) throws ParseException {
		LOGGER.info("Fetching stocks based on code,date {}", code);
		//String startDate="2022-07-01";
		//String endDate="2022-08-24";
		return new ResponseEntity<List<StockDto>>(stockService.getCompanyStocks(code, startDate, endDate),
				HttpStatus.OK);
	}

	@ApiOperation(value = "Get min,max and avg stock price", response = List.class)
	@GetMapping(value = "/aggregate/{code}")
	public ResponseEntity<List<StockAggregate>> getCompanyAggregate(@PathVariable String code) throws ParseException {
		LOGGER.info("Fetching min,max and average stock price based on company code {}", code);
		return new ResponseEntity<List<StockAggregate>>(stockService.getStocksAggregate(code), HttpStatus.OK);
	}

}

