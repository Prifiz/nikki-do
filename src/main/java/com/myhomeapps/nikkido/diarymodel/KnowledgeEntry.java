package com.myhomeapps.nikkido.diarymodel;

import org.joda.time.DateTime;

/**
 *
 * @author Prifiz
 */
public class KnowledgeEntry {
    
    private String shortDescription;
    private String content;
    private ApplicationArea applicationArea;
    private KnowledgeSource source;
    private DateTime changeDate;
    
    @Override
    public String toString() {
        return "Description:\n" + shortDescription + "\nContent:\n" + content;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ApplicationArea getApplicationArea() {
        return applicationArea;
    }

    public void setApplicationArea(ApplicationArea applicationArea) {
        this.applicationArea = applicationArea;
    }

    public KnowledgeSource getSource() {
        return source;
    }

    public void setSource(KnowledgeSource source) {
        this.source = source;
    }

    public DateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(DateTime changeDate) {
        this.changeDate = changeDate;
    }
}
