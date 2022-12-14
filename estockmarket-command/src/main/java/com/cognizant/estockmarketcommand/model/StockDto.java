package com.cognizant.estockmarketcommand.model;

import java.math.BigInteger;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {
	private BigInteger id;
	private String companyCode;
	private Double price;
	private Date createdOn;
	private Date updatedOn;

}
