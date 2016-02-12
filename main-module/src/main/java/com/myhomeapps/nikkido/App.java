package com.myhomeapps.nikkido;

import com.myhomeapps.nikkido.jaxb.JaxbParser;
import com.myhomeapps.nikkido.knowledge.Area;
import com.myhomeapps.nikkido.knowledge.Source;
import com.myhomeapps.nikkido.knowledge.TheoreticalKnowledge;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vaba1010 on 19.01.2016.
 */
public class App {

    public static void main(String[] args) throws Exception {
        Diary diary = new Diary();
        Record record = new Record();
        record.setChangeDate(new Date());
        List<AbstractRecordElement> elements = new ArrayList<>();
        AbstractRecordElement knowledge = new TheoreticalKnowledge(Area.PHYSICS, "blblbl", new Source("Neverland"), "ololo physics!!!");
        elements.add(knowledge);
        record.setElements(elements);
        diary.addRecord(record);

        diary.addRecord(new Record(new Date()));
        diary.addRecord(new Record(new Date()));
        diary.addRecord(new Record(new Date()));

        //System.out.println(new Date());

        Parser parser = new JaxbParser();
        parser.saveObject(new File("1.xml"), diary);

        Diary unmarshalled = (Diary) parser.getObject(new File("1.xml"), Diary.class);
        System.out.println(((TheoreticalKnowledge)unmarshalled.getRecords().get(0).getElements().get(0)).getContent());
    }
}
