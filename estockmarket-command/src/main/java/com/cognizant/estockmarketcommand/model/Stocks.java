package com.cognizant.estockmarketcommand.model;

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
public class Stocks {
	@Id
	private BigInteger id;
	private String companyCode;
	private Double price;
	private Long createdOn;
	private Long updatedOn;
}
