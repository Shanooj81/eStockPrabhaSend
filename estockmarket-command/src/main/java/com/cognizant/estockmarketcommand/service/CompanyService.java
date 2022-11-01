package com.cognizant.estockmarketcommand.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.estockmarketcommand.exception.CompanyAlreadyExistsException;
import com.cognizant.estockmarketcommand.model.Company;
import com.cognizant.estockmarketcommand.repository.CompanyRepository;

@Service
public class CompanyService {
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CompanyRepository companyRepository;

	public ResponseEntity<Company> createCompany(Company company) {
		Optional<Company> companyIsPresent = companyRepository.findByCompanyCode(company.getCompanyCode());
		Company companyresult = new Company();
		if (companyIsPresent.isEmpty()) {
			companyresult = companyRepository.save(company);
			LOGGER.info("Company details saved successfully!! {}",company);
			return new ResponseEntity<Company>(companyresult, HttpStatus.CREATED);
		}
		throw new CompanyAlreadyExistsException();
	}
	
	@Transactional
	public ResponseEntity<Boolean> removeCompany(String code) {
		Optional<Company> company = companyRepository.findByCompanyCode(code);
		if (company.isPresent()) {
			long value = companyRepository.deleteByCompanyCode(code);
			LOGGER.info("Company details removed from DB!! {}",company);
			if(value >= 1) {
				return new ResponseEntity<>(true, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(false, HttpStatus.OK);
	}
}
