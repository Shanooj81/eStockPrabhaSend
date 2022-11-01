package com.cognizant.estockmarketquery.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
	@Id
	private BigInteger id;
	private String companyCode;
	private String companyName;
	private String ceo;
	private Double companyTurnover;
	private String companyWebsite;
	private String stockExchangeName;
}
