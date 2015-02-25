/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhomeapps.nikkido.storagehandler;

import com.myhomeapps.nikkido.diarymodel.*;
import com.myhomeapps.nikkido.exceptions.HandleableException;
import com.myhomeapps.nikkido.storagehandler.filehandler.TextFileHandler;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;

import java.io.*;
import java.util.*;

/**
 *
 * @author Prifiz
 */
public class XMLFileStorage implements DataStorage {

    @Override
    public Diary load(String fileName) {
        String owner = "";
        // TODO
        // get owner from filename
        Diary result = new Diary(owner);
        try {
            Document document = parse(fileName);
            Element root = document.getRootElement();
            for(Iterator it = root.elementIterator(); it.hasNext();) {
                Record record = new Record();
                Element recordElement = (Element) it.next();
                Element knowledgeSetElement = recordElement.element("knowledgeSet");
                List<KnowledgeEntry> knowledgeList = new ArrayList<>();

                for(Iterator knowIt = knowledgeSetElement.elementIterator(); knowIt.hasNext();) {
                    Element knowledgeElement = (Element) knowIt.next();
                    KnowledgeEntry entry = new KnowledgeEntry();
                    entry.setChangeDate(new DateTime(knowledgeElement.element("changeDate").getText()));
                    entry.setShortDescription(knowledgeElement.element("shortDescription").getText());
                    entry.setContent(knowledgeElement.element("content").getText());
                    entry.setApplicationArea(new ApplicationArea(knowledgeElement.element("applicationArea").getText()));
                    Element sourceElement = knowledgeElement.element("source");
                    KnowledgeSource knowledgeSource = new KnowledgeSource();
                    knowledgeSource.setType(sourceElement.element("type").getText());
                    entry.setSource(knowledgeSource);
                    //knowledgeSource.setHowToFind(sourceElement.element("howToFind").getText());
                    knowledgeList.add(entry);
                }
                record.setKnowledge(new Knowledge(knowledgeList));

                Element thoughtsSetElement = recordElement.element("thoughts");
                List<ThoughtsEntry> thoughtsList = new ArrayList<>();

                for(Iterator thoughtsIt = thoughtsSetElement.elementIterator(); thoughtsIt.hasNext();) {
                    Element thoughtElement = (Element) thoughtsIt.next();
                    ThoughtsEntry entry = new ThoughtsEntry();
                    entry.setChangeDate(new DateTime(thoughtElement.element("changeDate").getText()));
                    entry.setThoughts(thoughtElement.element("content").getText());
                    thoughtsList.add(entry);
                }
                record.setThoughts(new Thoughts(thoughtsList));

                Element aphorismElement = recordElement.element("aphorism");
                Aphorism aphorism = new Aphorism();
                aphorism.setChangeDate(new DateTime(aphorismElement.element("changeDate").getText()));
                aphorism.setAphorismEntry(aphorismElement.element("content").getText());
                record.setAphorism(aphorism);

                result.addRecord(record);
            }

        } catch (DocumentException ex) {
            System.out.println("ERROR while parsing XML");
        }

        return result;
    }

    private Document parse(String fileName) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(fileName));
        return document;
    }

    private Document createDocument(Diary diary) {
        Document document = DocumentHelper.createDocument();

        Element root = document.addElement("diary").addAttribute("user", diary.getUserName());
        for(Record record : diary.getEntry()) {
            Element recordElement = root.addElement("record").addAttribute("date", new DateTime().toLocalDate().toString());
            Element knowledgeSetElement = recordElement.addElement("knowledgeSet");
            for(KnowledgeEntry entry : ((Knowledge) record.getKnowledge()).getKnowledgeList()) {
                Element knowledgeElement = knowledgeSetElement.addElement("knowledge");
                knowledgeElement.addElement("changeDate").setText(entry.getChangeDate().toString());
                knowledgeElement.addElement("shortDescription").setText(entry.getShortDescription());
                knowledgeElement.addElement("content").setText(entry.getContent());
                knowledgeElement.addElement("applicationArea").setText(entry.getApplicationArea().toString());
                Element sourceElement = knowledgeElement.addElement("source");
                sourceElement.addElement("type").setText(entry.getSource().getType());
                //sourceElement.addElement("howToFind").setText(entry.getSource().getHowToFind());
            }

            Element thoughtsElement = recordElement.addElement("thoughts");
            for(ThoughtsEntry entry : ((Thoughts) record.getThoughts()).getThoughtsList()) {
                Element singleThoughtElement = thoughtsElement.addElement("thought");
                singleThoughtElement.addElement("changeDate").setText(entry.getChangeDate().toString());
                singleThoughtElement.addElement("content").setText(entry.getThoughts());
            }

            Element aphorismElement = recordElement.addElement("aphorism");
            Aphorism aphorism = (Aphorism) record.getAphorism();
            aphorismElement.addElement("changeDate").setText(aphorism.getChangeDate().toString());
            aphorismElement.addElement("content").setText(aphorism.getAphorismEntry());
        }

        return document;
    }

    @Override
    public void save(Diary diary, String fileName) {
        Document document = createDocument(diary);
        try {
            write(document, fileName);
        } catch (IOException ex) {
            System.out.println("ERROR while writing XML doc");
        }
    }

    public void write(Document document, String fileName) throws IOException {

        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileWriter(fileName), format);
        writer.write( document );
        writer.close();
    }
}
