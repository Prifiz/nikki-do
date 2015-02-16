/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhomeapps.nikkido.diarymodel;

import org.joda.time.*;

/**
 *
 * @author Prifiz
 */
public class Aphorism extends AbstractRecordField {
    
    private int aphorismId;
    private DateTime changeDate;
    private String aphorismEntry;
    private int maxLength = 50;
    
    public Aphorism() {
        displayName = "aphorism";
    }   

    public int getAphorismId() {
        return aphorismId;
    }

    public void setAphorismId(int aphorismId) {
        this.aphorismId = aphorismId;
    }

    public DateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(DateTime changeDate) {
        this.changeDate = changeDate;
    }

    public String getAphorismEntry() {
        return aphorismEntry;
    }

    public void setAphorismEntry(String aphorismEntry) {
        this.aphorismEntry = aphorismEntry;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}