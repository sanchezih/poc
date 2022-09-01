package com.sanchezih.di.spring;

import com.sanchezih.di.spring.service.Converter;
import com.sanchezih.di.spring.service.impl.ARSToUSDConverter;

public class Main {

	public static void main(String[] args) {

		double cantidad = 100;
		Converter c = new ARSToUSDConverter();
		System.out.println(c.convert(cantidad));

	}
}
