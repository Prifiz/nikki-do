package com.myhomeapps.nikkido.diarymodel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prifiz
 */
public class Knowledge extends AbstractRecordField {
    
    private int knowledgeId;
    private List<KnowledgeEntry> knowledgeList;
    
    public Knowledge() {
        knowledgeList = new ArrayList<>();
        displayName = "knowledge";
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(KnowledgeEntry entry : knowledgeList) {
            stringBuilder.append(entry.toString());
            stringBuilder.append("\n======================================\n");
        }
        return stringBuilder.toString();
    }

    public void addKnowledgeEntry(KnowledgeEntry knowledgeEntry) {
        knowledgeList.add(knowledgeEntry);
    }
    
    public int getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(int knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public List<KnowledgeEntry> getKnowledgeList() {
        return knowledgeList;
    }

    public void setKnowledgeList(List<KnowledgeEntry> knowledgeList) {
        this.knowledgeList = knowledgeList;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}