/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhomeapps.nikkido.diarymodel;

/**
 *
 * @author Prifiz
 */
public class KnowledgeSource {
    
    private String type; // book, internet, etc.
    private String howToFind;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHowToFind() {
        return howToFind;
    }

    public void setHowToFind(String howToFind) {
        this.howToFind = howToFind;
    }
}
