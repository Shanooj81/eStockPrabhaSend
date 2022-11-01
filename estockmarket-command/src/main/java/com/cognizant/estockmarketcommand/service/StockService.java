package com.cognizant.estockmarketcommand.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.estockmarketcommand.model.StockDto;
import com.cognizant.estockmarketcommand.model.Stocks;
import com.cognizant.estockmarketcommand.repository.StockRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.modelmapper.ModelMapper;

@Service
public class StockService {
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private StockRepository stockRepository;
	
	public StockDto createStock(StockDto stockDto) throws JsonProcessingException {
		Stocks stocks = (Stocks) modelMapper.map(stockDto, Stocks.class);
		Stocks stocksResult = stockRepository.save(stocks);
		LOGGER.info("Stocks saved successfully to db!! {}", stocksResult);
		return (StockDto) modelMapper.map(stocksResult, StockDto.class);
	}
	
	@SuppressWarnings("unchecked")
	private Object map(Object object, @SuppressWarnings("rawtypes") Class clas) {
		return object != null ? modelMapper.map(object, clas) : null;
	}
}
