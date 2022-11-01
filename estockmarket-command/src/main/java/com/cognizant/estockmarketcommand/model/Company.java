package com.cognizant.estockmarketcommand.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Company {
	@Id
	private BigInteger id;
	private String companyCode;
	private String companyName;
	private String ceo;
	private Double companyTurnover;
	private String companyWebsite;
	
	public Company(BigInteger id, String companyCode, String companyName, String ceo, Double companyTurnover,
			String companyWebsite, String stockExchangeName) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.ceo = ceo;
		this.companyTurnover = companyTurnover;
		this.companyWebsite = companyWebsite;
		this.stockExchangeName = stockExchangeName;
	}
	public Company() {
		super();
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public Double getCompanyTurnover() {
		return companyTurnover;
	}
	public void setCompanyTurnover(Double companyTurnover) {
		this.companyTurnover = companyTurnover;
	}
	public String getCompanyWebsite() {
		return companyWebsite;
	}
	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}
	public String getStockExchangeName() {
		return stockExchangeName;
	}
	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}
	private String stockExchangeName;
}
