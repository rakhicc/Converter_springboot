package com.converter.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Text {
    private List<Sentence> sentences = new ArrayList<>();

    @XmlElement(name = "sentence")
    public List<Sentence> getSentences() {
        return sentences;
    }
}
