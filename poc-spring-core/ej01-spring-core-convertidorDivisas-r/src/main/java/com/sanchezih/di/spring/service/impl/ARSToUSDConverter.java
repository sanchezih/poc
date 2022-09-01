package com.sanchezih.di.spring.service.impl;

import com.sanchezih.di.spring.service.Converter;

public class ARSToUSDConverter implements Converter {

	private final double RATE = 138.53;

	@Override
	public Double convert(Double cantidad) {
		return cantidad * RATE;
	}
}
