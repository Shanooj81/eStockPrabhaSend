package com.cognizant.estockmarketquery.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.estockmarketquery.exception.InvalidCompanyCodeException;
import com.cognizant.estockmarketquery.model.Company;
import com.cognizant.estockmarketquery.repository.CompanyRepository;

@Service
public class CompanyService {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CompanyRepository companyrepository;

	public List<Company> getCompany() {
		LOGGER.info("Fetching all the company details");
		List<Company> comList = companyrepository.findAll();
		return comList;
	}

	public Company getCompanyById(String code) {
		LOGGER.info("Fetching company based on its code {}", code);
		Company company = companyrepository.findByCompanyCode(code);
		if(company != null) {
			return company;
		}
		throw new InvalidCompanyCodeException();

	}
}
