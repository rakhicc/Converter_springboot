package com.converter.service;

import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Service;
@Service
public interface ConverterService {
	
	String convertInputToXml(String[] text) throws JAXBException;
	
	String convertInputToCsv(String[] text);
	

}
