package com.converter.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Sentence {
    private List<String> words;

    @XmlElement(name = "word")
    public List<String> getWords() {
        return words;
    }

    public Sentence(List<String> words) {
	super();
	this.words = words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}




	
	  
	  
	 
