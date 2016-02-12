package com.myhomeapps.nikkido;

import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * Created by vaba1010 on 21.01.2016.
 */
public interface Parser {
    Object getObject(File file, Class c) throws JAXBException;
    void saveObject(File file, Object o) throws JAXBException;
}
