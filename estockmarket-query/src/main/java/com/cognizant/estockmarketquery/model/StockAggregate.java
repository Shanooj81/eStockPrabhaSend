package com.cognizant.estockmarketquery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockAggregate {
	private String companyCode;
	private Double minPrice;
	private Double maxPrice;
	private Double avgPrice;
}
