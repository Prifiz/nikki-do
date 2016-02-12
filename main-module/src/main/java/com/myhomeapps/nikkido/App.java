package com.myhomeapps.nikkido;

import com.myhomeapps.nikkido.Diary;
import com.myhomeapps.nikkido.Parser;
import com.myhomeapps.nikkido.Record;
import com.myhomeapps.nikkido.jaxb.JaxbParser;

import java.io.File;

/**
 * Created by vaba1010 on 19.01.2016.
 */
public class App {

    public static void main(String[] args) throws Exception {
        Diary diary = new Diary();
        diary.addRecord(new Record());

        Parser parser = new JaxbParser();
        parser.saveObject(new File("1.xml"), diary);
    }
}
