/**
 * 
 */
package com.converter.serviceImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Service;

import com.converter.model.Sentence;
import com.converter.model.Text;
import com.converter.service.ConverterService;


/**
 * @author rakhchan
 *
 */
@Service
public class ConverterServiceImpl implements ConverterService {

	@Override
	public String convertInputToXml(String[] text) throws JAXBException {
		// map creation to store sentences and sorted words
		Map<Sentence, List<String>> sentenceMap = new LinkedHashMap<Sentence, List<String>>();

		for (String sentence : text) {
		    sentence = sentence.trim();
		    if (!sentence.isEmpty()) {
			sentence = sentence.replaceAll("[-()]", "");
			// sentence splitting

			String[] words = sentence.split("\\s*(?<!\\w)'|'\\s*(?!\\w)|\\s*(\\s|,|\\.|;|:|!|\\?|\\\")\\s*");
			// sorting words of sentence
			List<String> sortedWords = Arrays.asList(words);
			Collections.sort(sortedWords, String.CASE_INSENSITIVE_ORDER);

			// Create a Sentence object and add it to the map
			sentenceMap.put(new Sentence(sortedWords), sortedWords);
		    }
		}


		// Converting map to desired XML format
		String xml = convertToXML(sentenceMap);
		System.out.println(xml);
		
		  // Save XML output to file
	        saveToXMLFile(xml, "c:/temp/small.xml");

		return null;
	}
	private static void saveToXMLFile(String xml, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(xml);
            System.out.println("XML file saved successfully.");
        } catch (IOException e) {
            System.err.println("Error writing XML file: " + e.getMessage());
        }
    }
	private static String convertToXML(Map<Sentence, List<String>> sentenceMap) throws JAXBException {
		Text text = new Text();
		for (Sentence sentence : sentenceMap.keySet()) {
		    Sentence sentenceXml = new Sentence(sentenceMap.get(sentence));
		    text.getSentences().add(sentenceXml);
		}

		// Create JAXB context and marshaller
		JAXBContext jaxbContext = JAXBContext.newInstance(Text.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// Marshal to XML
		StringWriter writer = new StringWriter();
		marshaller.marshal(text, writer);
		return writer.toString();
	    }
	@Override
	public String convertInputToCsv(String[] sentences) {
		// TODO Auto-generated method stub
		// Create a map to store sentences and sorted words
		Map<Sentence, List<String>> sentenceMap = new LinkedHashMap<>();

		// Sentence processing
		int maximumWords = 0;
		for (String sentence : sentences) {
		    // remove leading and trailing whitespace
		    sentence = sentence.trim();
		    if (!sentence.isEmpty()) {
			// Split the sentence into words, removing unnecessary whitespace and punctuation
			String[] words = sentence.split("\\s*(\\s|,|\\.|;|:|!|\\?|\\'|\\\")\\s*");
			// Remove empty strings from the array (e.g., caused by consecutive delimiters)
			words = Arrays.stream(words).filter(word -> !word.isEmpty()).toArray(String[]::new);

			// Convert words to lowercase and sort them
			List<String> sortedWords = Arrays.asList(words);
			Collections.sort(sortedWords, String.CASE_INSENSITIVE_ORDER);

			// Create a Sentence object and add it to the map
			Sentence sentenceNew = new Sentence(sortedWords);
			sentenceMap.put(sentenceNew, sortedWords);

			// Update maximumWords if necessary
			maximumWords = Math.max(maximumWords, sortedWords.size());
		    }
		}

		// Convert sentenceMap to CSV
		String csv = convertToCSV(sentenceMap, maximumWords);
		saveToCSVFile(csv, "c:/temp/small.csv");
		System.out.println(csv);
		return csv;
	    }

	    private static String convertToCSV(Map<Sentence, List<String>> sentenceMap, int maxWords) {
		StringBuilder csvBuilder = new StringBuilder();

		// Appending header
		csvBuilder.append(",");
		for (int i = 1; i <= maxWords; i++) {
		    csvBuilder.append("Word ").append(i).append(",");
		}
		csvBuilder.append("\n");

		// Iterating over sentences and words to form csv
		int sentenceIndex = 1;
		for (Sentence sentence : sentenceMap.keySet()) {
		    csvBuilder.append("Sentence").append(sentenceIndex++).append(",");
		    List<String> words = sentenceMap.get(sentence);
		    for (String word : words) {
			csvBuilder.append(word).append(",");
		    }
		    // Fill in remaining empty slots with empty strings
		    int remainingEmptySlots = maxWords - words.size();
		    for (int i = 0; i < remainingEmptySlots; i++) {
			csvBuilder.append(",");
		    }
		    csvBuilder.append("\n");
		}

		return csvBuilder.toString();
	    }

	    private static void saveToCSVFile(String csv, String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
		    writer.write(csv);
		    System.out.println("CSV file saved successfully.");
		} catch (IOException e) {
		    System.err.println("Error writing CSV file: " + e.getMessage());
		}
	    }
	    
	  

}
