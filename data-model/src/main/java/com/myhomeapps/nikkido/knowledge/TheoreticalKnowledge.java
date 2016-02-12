package com.myhomeapps.nikkido.knowledge;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vaba1010 on 19.01.2016.
 */

@XmlRootElement(name = "recordElement.knowledge")
@XmlAccessorType(XmlAccessType.FIELD)
public class TheoreticalKnowledge extends AbstractKnowledge {
    @XmlElement
    private Area area;
    @XmlElement
    private String content;

    public TheoreticalKnowledge() {}

    public TheoreticalKnowledge(Area area, String content, Source source, String applications) {
        super(source, applications);
        this.area = area;
        this.content = content;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
