package com.myhomeapps.nikkido.knowledge;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vaba1010 on 19.01.2016.
 */

@XmlRootElement(name = "source")
public class Source {

    private String description;

    public Source() {}

    public Source(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
