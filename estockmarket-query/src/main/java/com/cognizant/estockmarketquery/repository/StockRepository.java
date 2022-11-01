package com.cognizant.estockmarketquery.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.estockmarketquery.model.Stocks;

@Repository
public interface StockRepository extends MongoRepository<Stocks, BigInteger>{

}
