package com.myhomeapps.nikkido.knowledge;

import com.myhomeapps.nikkido.AbstractRecordElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Created by vaba1010 on 19.01.2016.
 */

@XmlSeeAlso(TheoreticalKnowledge.class)
public abstract class AbstractKnowledge extends AbstractRecordElement {


    private Source source;
    private String applications;

    public AbstractKnowledge() {}

    public AbstractKnowledge(Source source, String applications) {
        this.source = source;
        this.applications = applications;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getApplications() {
        return applications;
    }

    public void setApplications(String applications) {
        this.applications = applications;
    }
}
