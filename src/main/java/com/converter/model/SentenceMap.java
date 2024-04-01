package com.converter.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


//@XmlRootElement (name="text")
//@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class SentenceMap {
	
  private Map<Sentence, String[]> sentence = new LinkedHashMap<Sentence,String[] >();
  //@XmlElement
public Map<Sentence, String[]> getSentence() {
	return sentence;
}

public void setSentence(Map<Sentence, String[]> sentence) {
	this.sentence = sentence;
}
  

  
  






  
 
 
}
