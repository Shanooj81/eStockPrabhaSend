package com.cognizant.estockmarketcommand.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.estockmarketcommand.model.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company, BigInteger> {
	Optional<Company> findByCompanyCode(String companyCode);
	long deleteByCompanyCode(String code);
}
