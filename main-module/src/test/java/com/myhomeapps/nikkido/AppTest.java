package com.myhomeapps.nikkido;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Created by vaba1010 on 12.02.2016.
 */
public class AppTest {

    private static final Logger LOGGER = Logger.getLogger(AppTest.class);

    @Test
    public void Test() {
        LOGGER.info("!!! TEST LOG MESSAGE !!!");
    }
}
