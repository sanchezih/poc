package com.github.sanchezih.market.dto;

import java.math.BigDecimal;

public class ProductDto {

	private Long id;
	private String name;
	private BigDecimal cost;
	private Integer typeId;

	public ProductDto() {
	}

	public ProductDto(Long id, String name, BigDecimal cost, Integer typeId) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.typeId = typeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

}
