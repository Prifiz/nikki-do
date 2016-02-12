package com.myhomeapps.nikkido.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vaba1010 on 22.01.2016.
 */
public class DateAdapter extends XmlAdapter<String, Date> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String marshal(Date v) throws Exception {
        return dateFormat.format(v);
    }

    @Override
    public Date unmarshal(String v) throws Exception {
        return dateFormat.parse(v);
    }

}
