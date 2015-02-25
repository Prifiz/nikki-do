package com.myhomeapps.nikkido.diarymodel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prifiz
 */
public class Thoughts extends AbstractRecordField {
    
    private List<ThoughtsEntry> thoughtsList;
       
    public Thoughts() {
        thoughtsList = new ArrayList<>();
        displayName = "thoughts";
    }

    public Thoughts(List<ThoughtsEntry> thoughtsList) {
        this.thoughtsList = thoughtsList;
        displayName = "thoughts";
    }
    
    public void addThoughtsEntry(ThoughtsEntry entry) {
        thoughtsList.add(entry);
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(ThoughtsEntry entry : thoughtsList) {
            stringBuilder.append(entry.toString());
            stringBuilder.append("\n");
            stringBuilder.append("*****************************************\n");
        }
        return stringBuilder.toString();
    }

    public List<ThoughtsEntry> getThoughtsList() {
        return thoughtsList;
    }

    public void setThoughtsList(List<ThoughtsEntry> thoughtsList) {
        this.thoughtsList = thoughtsList;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
