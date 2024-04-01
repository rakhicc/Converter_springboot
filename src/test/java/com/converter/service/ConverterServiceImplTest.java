package com.converter.service;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.converter.serviceImpl.ConverterServiceImpl;

public class ConverterServiceImplTest {
	
	@Autowired
	private ConverterServiceImpl converterService;
	
	
	@Test
	public void testConvertInputToXml() throws JAXBException {
		converterService = new ConverterServiceImpl();
		String inputText = "What	he  shouted was shocking:  åœåœ¨é‚£å„¿, ä½ è¿™è‚®è„çš„æŽ å¤ºè€…! I couldn't understand a word,perhaps because Chinese \r\n"
			+ " isn't my mother tongue. I was just standing there watching Mr. Young marching around - he \r\n"
			+ "was    furious.   Why was he directing  his  anger at me? Little did I know 	about 	that.\r\n"
			+ "\r\n"
			+ "Nordea Markets is the leading international capital markets operator and investment banking partner in the Nordic and Baltic Sea regions.\r\n"
			+ "We are located next door to you , connecting you to the global markets. \r\n"
			+ "\r\n"
			+ "We combine local expertise with global strength to provide you with a complete portfolio of financial services and solutions. We have \r\n"
			+ "one of the strongest, most diversified product ranges in the Nordics and offer outstanding liquidity in local currencies.\r\n"
			+ "\r\n"
			+ "But more significantly, we offer you access to an unequalled team of experts ,in all facets of capital markets, dedicated to serving \r\n"
			+ "you in the best possible manner.\r\n"
			+ "At Nordea Markets we have a rare combination of local expertise and global strength which gives you, our customer, the opportunity to use us for a wide variety of financial services and solutions.\r\n"
			+ "In fact - in all of the Nordics, youâ€™d have a hard time finding a product range as strong and diversified as ours (and we can give you excellent liquidity in local currencies too). But most importantly, we have a huge team of outstanding specialists ready to serve you, no matter what your financial challenge might be.";

		// Parse the input text into sentences
		String[] sentences = inputText.split("[.!?]+");
		converterService.convertInputToXml(sentences);
	}
	@Test
	public void testConvertInputToCsv() throws JAXBException {
		converterService = new ConverterServiceImpl();
		//String inputText = "Mary had a little lamb. Peter called for the wolf, and Aesop came.\nCinderella likes shoes.";
		String inputText = "What	he  shouted was shocking:  åœåœ¨é‚£å„¿, ä½ è¿™è‚®è„çš„æŽ å¤ºè€…! I couldn't understand a word,perhaps because Chinese \r\n"
			+ " isn't my mother tongue. I was just standing there watching Mr. Young marching around - he \r\n"
			+ "was    furious.   Why was he directing  his  anger at me? Little did I know 	about 	that.\r\n"
			+ "\r\n"
			+ "Nordea Markets is the leading international capital markets operator and investment banking partner in the Nordic and Baltic Sea regions.\r\n"
			+ "We are located next door to you , connecting you to the global markets. \r\n"
			+ "\r\n"
			+ "We combine local expertise with global strength to provide you with a complete portfolio of financial services and solutions. We have \r\n"
			+ "one of the strongest, most diversified product ranges in the Nordics and offer outstanding liquidity in local currencies.\r\n"
			+ "\r\n"
			+ "But more significantly, we offer you access to an unequalled team of experts ,in all facets of capital markets, dedicated to serving \r\n"
			+ "you in the best possible manner.\r\n"
			+ "At Nordea Markets we have a rare combination of local expertise and global strength which gives you, our customer, the opportunity to use us for a wide variety of financial services and solutions.\r\n"
			+ "In fact - in all of the Nordics, youâ€™d have a hard time finding a product range as strong and diversified as ours (and we can give you excellent liquidity in local currencies too). But most importantly, we have a huge team of outstanding specialists ready to serve you, no matter what your financial challenge might be.";

		// Parse the input text into sentences
		String[] sentences = inputText.split("[.!?]+");
		converterService.convertInputToCsv(sentences);
	}
}
