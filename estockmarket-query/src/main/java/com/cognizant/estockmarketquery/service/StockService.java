package com.cognizant.estockmarketquery.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.cognizant.estockmarketquery.model.StockAggregate;
import com.cognizant.estockmarketquery.model.StockDto;
import com.cognizant.estockmarketquery.model.Stocks;
import com.cognizant.estockmarketquery.repository.StockRepository;

import org.modelmapper.ModelMapper;

@Service
public class StockService {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	StockRepository stockRepo;

	@Autowired
	private MongoOperations mongoOperations;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<StockDto> getCompanyStocks(String companyCode, String startDate, String endDate) throws java.text.ParseException {
		LOGGER.info("fetch company stocks based on code,date {}", companyCode,startDate,endDate);
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");		
		Date start = f. parse(startDate);
		Date end = f. parse(endDate);
		long milliseconds1 = start. getTime();
		long milliseconds2 = end. getTime();	
		Query query = new Query();
		query.addCriteria(getStockQuery(companyCode, milliseconds1, milliseconds2));
		List<Stocks> stocksList = mongoOperations.find(query, Stocks.class);
		List<StockDto> stockDtos = new ArrayList<>();
		stocksList.forEach(stocks -> {
			StockDto stockDto = (StockDto) modelMapper.map(stocks, StockDto.class);
			stockDtos.add(stockDto);
		});
		return stockDtos;
	}
	
	private Criteria getStockQuery(String companyCode, long milliseconds1, long milliseconds2) {
		LOGGER.info("Fetch stock details based on code {}", companyCode,milliseconds1,milliseconds2);
		Criteria criteria = Criteria.where("companyCode").is(companyCode);
		if (milliseconds1 != 0 && milliseconds2 != 0) {
			criteria.andOperator(Criteria.where("createdOn").gte(milliseconds1).lte(milliseconds2));
		}
		return criteria;
	}
	
	private Criteria getStockQuery(String companyCode) {
		LOGGER.info("Fetch stock details based on code {}", companyCode);
		Criteria criteria = Criteria.where("companyCode").is(companyCode);
		return criteria;
	}

	public List<StockAggregate> getStocksAggregate(String companyCode) throws java.text.ParseException {
		LOGGER.info("fetch stockaggregate based on code {}", companyCode);
		MatchOperation matchStage = Aggregation
				.match(getStockQuery(companyCode));
		GroupOperation group = Aggregation.group("companyCode").first("companyCode").as("companyCode").min("price")
				.as("minPrice").max("price").as("maxPrice").avg("price").as("avgPrice");
		Aggregation aggregation = Aggregation.newAggregation(matchStage, group);

		AggregationResults<StockAggregate> output = mongoTemplate.aggregate(aggregation, Stocks.class,
				StockAggregate.class);
		return output != null ? output.getMappedResults() : null;
	}

	public void createStock(Stocks stocks) {
		LOGGER.info("save stocks {}", stocks);
		stockRepo.save(stocks);
	}
	
	@SuppressWarnings("unchecked")
	private Object map(Object object, @SuppressWarnings("rawtypes") Class clas) {
		return object != null ? modelMapper.map(object, clas) : null;
	}
}
