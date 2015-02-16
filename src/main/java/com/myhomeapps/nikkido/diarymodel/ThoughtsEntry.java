/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhomeapps.nikkido.diarymodel;

import org.joda.time.DateTime;

/**
 *
 * @author Prifiz
 */
public class ThoughtsEntry {
    
    private String thoughts;
    private DateTime changeDate;

    @Override
    public String toString() {
        return changeDate.toString() + "\nThoughts:\n" + thoughts;
    }
    
    public String getThoughts() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }

    public DateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(DateTime changeDate) {
        this.changeDate = changeDate;
    }
}
