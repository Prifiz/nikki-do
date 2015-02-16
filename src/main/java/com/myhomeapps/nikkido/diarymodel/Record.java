/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhomeapps.nikkido.diarymodel;

/**
 *
 * @author Prifiz
 */
public class Record implements Comparable<Record> {

    public Record(AbstractRecordField knowledge, AbstractRecordField thoughts, AbstractRecordField aphorism) {
        this.knowledge = knowledge;
        this.thoughts = thoughts;
        this.aphorism = aphorism;
    }
    private AbstractRecordField knowledge;
    private AbstractRecordField thoughts;
    private AbstractRecordField aphorism;

    @Override
    public String toString() {
        return knowledge.toString();// + thoughts.toString() + aphorism.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.knowledge != null ? this.knowledge.hashCode() : 0);
        hash = 17 * hash + (this.thoughts != null ? this.thoughts.hashCode() : 0);
        hash = 17 * hash + (this.aphorism != null ? this.aphorism.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Record other = (Record) obj;
        if (this.knowledge != other.knowledge && (this.knowledge == null || !this.knowledge.equals(other.knowledge))) {
            return false;
        }
        if (this.thoughts != other.thoughts && (this.thoughts == null || !this.thoughts.equals(other.thoughts))) {
            return false;
        }
        if (this.aphorism != other.aphorism && (this.aphorism == null || !this.aphorism.equals(other.aphorism))) {
            return false;
        }
        return true;
    }

    public AbstractRecordField getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }

    public AbstractRecordField getThoughts() {
        return thoughts;
    }

    public void setThoughts(Thoughts thoughts) {
        this.thoughts = thoughts;
    }

    public AbstractRecordField getAphorism() {
        return aphorism;
    }

    public void setAphorism(Aphorism aphorism) {
        this.aphorism = aphorism;
    }

    /// add comparison by date!!!
    @Override
    public int compareTo(Record t) {
        if (this.aphorism.equals(t.aphorism)
                && this.knowledge.equals(t.knowledge)
                && this.thoughts.equals(t.thoughts)) {
            return 0;
        } else {
            return 1;
        }
    }
}
