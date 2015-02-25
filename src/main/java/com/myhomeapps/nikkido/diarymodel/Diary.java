package com.myhomeapps.nikkido.diarymodel;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Prifiz
 */
public class Diary {

    public String getUserName() {
        return userName;
    }

    private String userName;

    private Set<Record> entry;
    
    public Diary(String owner) {
        userName = owner;
        entry = new TreeSet<>();
    }
    
    public void addRecord(Record record) {
        entry.add(record);
    }
    
    public void removeAllRecords() {
        entry.clear();
    }

    public Set<Record> getEntry() {
        return entry;
    }
}
