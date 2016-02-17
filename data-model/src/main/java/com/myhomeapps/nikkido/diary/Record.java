package com.myhomeapps.nikkido.diary;

import com.myhomeapps.nikkido.jaxb.DateAdapter;
import com.myhomeapps.nikkido.knowledge.AbstractKnowledge;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

/**
 * Created by vaba1010 on 19.01.2016.
 */

@XmlRootElement(name = "record")
@XmlAccessorType(XmlAccessType.FIELD)

public class Record {

    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date changeDate;

    @XmlElementWrapper( name = "recordElements" )
    @XmlElement( name="knowledge", type = AbstractKnowledge.class )
    private List<AbstractRecordElement> elements;

    public Record(Date changeDate) {
        this.changeDate = changeDate;
    }

    public Record() {
        this.changeDate = new Date();
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }


    public List<AbstractRecordElement> getElements() {
        return elements;
    }



    public void setElements(List<AbstractRecordElement> elements) {
        this.elements = elements;
    }
}
