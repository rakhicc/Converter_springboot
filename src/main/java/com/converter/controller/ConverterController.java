package com.converter.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.converter.ExceptionHandler.BadRequestException;
import com.converter.ExceptionHandler.InternalException;
import com.converter.service.ConverterService;



@RestController
public class ConverterController {
	@Autowired
	private ConverterService converterService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<?> FileUpload(@RequestParam("file") MultipartFile file)
			throws IOException, XMLStreamException, JAXBException, BadRequestException{
		try {
			List<String> lines = new ArrayList<String>();
			InputStream inputStream = file.getInputStream();
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
			String numberLine;
			while ((numberLine = bufferReader.readLine()) != null) {
				lines.add(numberLine);
			}
			bufferReader.close();
			if(lines.isEmpty()) {
				throw new BadRequestException("File has no content to process");
			}
			/* pint all lines */
			lines.forEach(System.out::println);
			String result = String.join("", lines);

			String str = result;
			
			String[] arrOfStr = str.split("[.!?]+");
			
			System.out.println("text to be converted"+arrOfStr);
			converterService.convertInputToXml(arrOfStr);
			converterService.convertInputToCsv(arrOfStr);
			return new ResponseEntity<>("conversion is success", HttpStatus.OK);	
		} catch (Exception exception) {
			if(exception instanceof BadRequestException) {
				throw new BadRequestException(exception.getMessage());
			} else {
			throw new InternalException("Exception while processing text");
			}
		}
		
	}

}