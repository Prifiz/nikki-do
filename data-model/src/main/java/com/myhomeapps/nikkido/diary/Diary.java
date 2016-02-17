package com.myhomeapps.nikkido.diary;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaba1010 on 19.01.2016.
 */

@XmlRootElement(name = "diary")
@XmlAccessorType (XmlAccessType.FIELD)
public class Diary {

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }


    @XmlElement(name = "record")
    private List<Record> records;

    public Diary() {
        records = new ArrayList<>();
    }

    public void addRecord(Record record) {
        records.add(record);
    }

}
