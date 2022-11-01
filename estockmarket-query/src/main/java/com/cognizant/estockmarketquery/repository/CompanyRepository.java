package com.cognizant.estockmarketquery.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.estockmarketquery.model.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company, BigInteger>{
	Company findByCompanyCode(String companyCode);
}
